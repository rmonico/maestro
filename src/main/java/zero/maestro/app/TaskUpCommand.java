package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.model.Task;

public class TaskUpCommand {

    @ArgumentsBean
    private TaskUpArguments args;

    @Bean
    private Task task;

    @Dependency
    private TaskDao dao;

    @CommandHandler(path = { "task", "up" })
    public void execute() throws SQLException, EasyMVCException {
        Task task = dao.queryForId(args.getTaskId());

        if (task == null) {
            String message = String.format("Task id #%d not found.", args.getTaskId());
            throw new RuntimeException(message);
        }

        if (args.getName() != null) {
            task.setName(args.getName());
        }

        if (args.getSupertaskID() != null) {
            Task superTask = dao.queryForId(args.getSupertaskID());

            if (superTask == null)
                throw new RuntimeException("Supertask id #45 not found.");

            task.setSuperTask(superTask);
        }

        // TODO Check if task was changed
        dao.update(task);
    }
}
