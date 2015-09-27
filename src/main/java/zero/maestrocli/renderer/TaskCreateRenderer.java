package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskCreateRenderer {

    private Task task;

    @Renderer(path = { "task", "add" })
    public void render() {
        Task superTask = task.getSuperTask();

        String message;
        if (superTask == null)
            message = String.format("New task created: \"%s\" (#%d)", task.getName(), task.getId());
        else
            message = String.format("New task created: \"%s\" -> \"%s\" (#%d)", superTask.getName(), task.getName(), task.getId());

        System.out.println(message);
    }

}
