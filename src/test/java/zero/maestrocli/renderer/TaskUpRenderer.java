package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.app.TaskUpArguments;
import zero.maestro.model.Task;

public class TaskUpRenderer {

    private TaskUpArguments args;
    private Task task;
    private Task oldTask;

    @Renderer(path = { "task", "up" })
    public void render() {
    }

}
