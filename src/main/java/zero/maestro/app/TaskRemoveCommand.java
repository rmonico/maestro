package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.PropertyDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Property;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class TaskRemoveCommand {

    @ArgumentsBean
    private TaskRemoveArguments args;

    @Dependency
    private TaskDao dao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Dependency
    private PropertyDao propertyDao;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "rm" })
    public void execute() throws SQLException, EasyMVCException {
        task = dao.queryForId(args.getTaskId());

        if (task == null)
            throw new EasyMVCException(String.format("No task with id #%d...", args.getTaskId()));

        removeProperties();

        List<TaskTag> taskTagQuery = taskTagDao.queryForTaskId(task.getId());

        taskTagDao.delete(taskTagQuery);

        dao.delete(task);
    }

    private void removeProperties() throws SQLException {
        QueryBuilder<TaskTag, Integer> taskTagBuilder = taskTagDao.queryBuilder();

        taskTagBuilder.where().eq(TaskTag.TASK_FIELD_NAME, args.getTaskId());

        taskTagBuilder.selectColumns(TaskTag.ID_FIELD_NAME);

        DeleteBuilder<Property, Integer> builder = propertyDao.deleteBuilder();

        Where<Property, Integer> where = builder.where();

        where.in(Property.TASKTAG_FIELD_NAME, taskTagBuilder);

        PreparedDelete<Property> query = builder.prepare();

        propertyDao.delete(query);
    }
}
