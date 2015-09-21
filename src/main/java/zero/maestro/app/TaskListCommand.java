package zero.maestro.app;

import java.util.List;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.model.Task;

public class TaskListCommand {

    @Dependency
    private TaskDao dao;

    @Bean
    private List<Task> tasks;

    @CommandHandler(path = { "task", "ls" })
    public void execute() {
        tasks = dao.queryForAll();
    }
}
