package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class TaskListCommand {

    @Dependency
    private TaskDao dao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Dependency
    private TagDao tagDao;

    @ArgumentsBean
    private TaskListArguments args;

    @Bean
    private List<Task> tasks;

    @CommandHandler(path = { "task", "ls" })
    public void execute() throws SQLException {
        QueryBuilder<Task, Integer> taskBuilder = dao.queryBuilder();

        String[] tags = args.getTags();
        if (tags != null) {
            QueryBuilder<Tag, Integer> tagBuilder = tagDao.queryBuilder();

            Where<Tag, Integer> where = tagBuilder.where();

            where.in(Tag.NAME_FIELD_NAME, (Object[]) tags);

            QueryBuilder<TaskTag, Integer> taskTagBuilder = taskTagDao.queryBuilder();

            taskTagBuilder.join(tagBuilder);

            taskBuilder.join(taskTagBuilder);
        }

        taskBuilder.groupBy(Task.ID_FIELD_NAME);

        PreparedQuery<Task> query = taskBuilder.prepare();

        tasks = dao.query(query);
    }
}
