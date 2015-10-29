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
        System.out.println(String.format("Task #%d:", task.getId()));

        if (args.getName() != null) {
            String message = String.format("Name: \"%s\" -> \"%s\"", oldTask.getName(), task.getName());
            System.out.println(message);
        }

        if (args.getSupertaskID() != null) {
            StringBuilder oldSuperTaskName = getSuperTaskNameOrNone(oldTask);

            StringBuilder superTaskName = getSuperTaskNameOrNone(task);

            String message = String.format("Supertask: %s -> %s", oldSuperTaskName, superTaskName);
            System.out.println(message);
        }
    }

    private StringBuilder getSuperTaskNameOrNone(Task task) {
        Task superTask = task.getSuperTask();

        if (superTask != null) {
            StringBuilder superTaskName = new StringBuilder("\"");
            superTaskName.append(superTask.getName());
            superTaskName.append("\"");

            return superTaskName;
        } else
            return new StringBuilder("<none>");
    }

}
