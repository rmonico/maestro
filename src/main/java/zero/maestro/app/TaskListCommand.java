package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.model.Task;

public class TaskListCommand {

    @Dependency
    private TaskDao dao;

    @ArgumentsBean
    private TaskListArguments args;

    @Bean
    private List<Task> tasks;

    @CommandHandler(path = { "task", "ls" })
    public void execute() throws SQLException {
        tasks = dao.queryForAll();
    }
}
