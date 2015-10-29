package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskUpRenderer {

    private Task task;
    private String oldTaskName;

    @Renderer(path = { "task", "up" })
    public void render() {
        System.out.println(String.format("Task #%d:", task.getId()));

        if (oldTaskName != null) {
            String message = String.format("Name: \"%s\" -> \"%s\"", oldTaskName, task.getName());
            System.out.println(message);
        }
    }

}
