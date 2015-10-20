package zero.maestro.app;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.CommandHandler;

public class TaskRemoveCommand {

    @ArgumentsBean
    private TaskRemoveArguments args;

    @CommandHandler(path = { "task", "rm" })
    public void execute() {

    }
}
