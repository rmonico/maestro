package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.app.TaskUpArguments;
import zero.maestro.model.Task;

public class TaskUpRenderer {

    @SuppressWarnings("unused")
    private TaskUpArguments args;
    @SuppressWarnings("unused")
    private Task task;
    @SuppressWarnings("unused")
    private Task oldTask;

    @Renderer(path = { "task", "up" })
    public void render() {
    }

}
