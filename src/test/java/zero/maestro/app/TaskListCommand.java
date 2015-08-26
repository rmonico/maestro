package zero.maestro.app;

import java.util.List;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.maestro.model.Task;

public class TaskListCommand {

    @Bean
    private List<Task> tasks;

    @CommandHandler(path = { "task", "ls" })
    public void execute() {

    }
}
