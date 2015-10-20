package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

public class TaskRemoveCommand {

    @ArgumentsBean
    private TaskRemoveArguments args;

    @Dependency
    private TaskDao dao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "rm" })
    public void execute() throws SQLException, EasyMVCException {
        task = dao.queryForId(args.getTaskId());

        if (task == null)
            throw new EasyMVCException(String.format("No task with id #%d...", args.getTaskId()));

        List<TaskTag> taskTagQuery = taskTagDao.queryForTaskId(task.getId());

        taskTagDao.delete(taskTagQuery);

        dao.delete(task);

    }
}
