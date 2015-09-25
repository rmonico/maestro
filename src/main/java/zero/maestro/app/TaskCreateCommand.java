package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.model.Task;

public class TaskCreateCommand {

    @Dependency
    private TaskDao dao;

    @ArgumentsBean
    private TaskCreateArguments args;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "add" })
    public void execute() throws SQLException {
        task = new Task();

        task.setName(args.getTaskName());

        Task superTask = getSuperTask();

        if (superTask != null)
            task.setSuperTask(superTask);

        dao.create(task);
    }

    private Task getSuperTask() throws SQLException {
        Integer superTaskID = args.getSuperTaskID();

        if (superTaskID == null)
            return null;

        Task superTask = dao.queryForId(superTaskID);

        return superTask;
    }

}
