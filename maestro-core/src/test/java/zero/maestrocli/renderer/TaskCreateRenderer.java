package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskCreateRenderer {

    @SuppressWarnings("unused")
    private Task task;

    @Renderer(path = { "task", "add" })
    public void render() {
    }

}
