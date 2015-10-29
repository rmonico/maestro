package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.app.TaskUpArguments;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

public class TaskUpRenderer {

    private TaskUpArguments args;
    private Task task;
    private Task oldTask;

    @Renderer(path = { "task", "up" })
    public void render() {
        System.out.println(String.format("Task #%d:", task.getId()));

        showNameChange();

        showSupertaskChange();

        showTagsChange();
    }

    private void showNameChange() {
        if (args.getName() == null)
            return;

        String message = String.format("Name: \"%s\" -> \"%s\"", oldTask.getName(), task.getName());
        System.out.println(message);
    }

    private void showSupertaskChange() {
        if (args.getSupertaskID() == null)
            return;

        StringBuilder oldSuperTaskName = formatSuperTaskName(oldTask);

        StringBuilder superTaskName = formatSuperTaskName(task);

        String message = String.format("Supertask: %s -> %s", oldSuperTaskName, superTaskName);
        System.out.println(message);
    }

    private void showTagsChange() {
        if (isTagsChanged())
            return;

        StringBuilder oldTags = formatTags(oldTask);
        StringBuilder tags = formatTags(task);

        String note;

        if (oldTags.toString().equals(tags.toString()))
            note = " (property changed?)";
        else
            note = "";

        String message = String.format("Tags: %s -> %s%s", oldTags, tags, note);
        System.out.println(message);
    }

    private boolean isTagsChanged() {
        return (args.getTags() == null) && (args.getTagsToRemove() == null);
    }

    private StringBuilder formatTags(Task task) {
        StringBuilder formatted = new StringBuilder();

        for (TaskTag taskTag : task.getTaskTags()) {
            formatted.append(taskTag.getTag().getName());
            formatted.append(",");
        }

        if (formatted.length() > 0)
            formatted.delete(formatted.length() - 1, formatted.length());

        formatted.insert(0, "[");

        formatted.append("]");

        return formatted;
    }

    private StringBuilder formatSuperTaskName(Task task) {
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
