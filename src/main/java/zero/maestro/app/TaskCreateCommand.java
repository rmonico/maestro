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

        dao.create(task);
    }

}
