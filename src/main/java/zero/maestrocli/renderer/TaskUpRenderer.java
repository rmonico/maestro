package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskUpRenderer {

    private Task task;

    @Renderer(path = { "task", "up" })
    public void render() {
    }

}
