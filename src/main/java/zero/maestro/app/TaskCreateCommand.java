package zero.maestro.app;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.maestro.model.Task;

public class TaskCreateCommand {

    @ArgumentsBean
    private TaskCreateArguments args;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "add" })
    public void execute() {
        task = new Task();

        task.setName("Some task");
    }

}
