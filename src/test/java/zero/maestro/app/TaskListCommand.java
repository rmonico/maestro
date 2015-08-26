package zero.maestro.app;

import java.util.LinkedList;
import java.util.List;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.maestro.model.Task;

public class TaskListCommand {

    @Bean
    private List<Task> tasks;

    @CommandHandler(path = { "task", "ls" })
    public void execute() {
        tasks = new LinkedList<>();

        createTask("First task ever");
        createTask("Second task");
        createTask("A third task");
    }

    private void createTask(String name) {
        Task task = new Task();

        task.setName(name);
        tasks.add(task);
    }
}
