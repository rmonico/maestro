package zero.maestrocli.renderer;

import java.util.List;

import zero.listprinter.DataExtractor;
import zero.maestro.model.Task;

public class TaskNameAsTreeExtractor implements DataExtractor {

    private Task task;
    private StringBuilder builder;
    private List<Task> tasks;

    public TaskNameAsTreeExtractor(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public Object extract(Object data) {
        task = (Task) data;

        builder = new StringBuilder();

        if (!isRoot(task))
            makeTreePrefixes();

        builder.append(task.getName());

        return builder.toString();
    }

    private boolean isRoot(Task task) {
        return task.getSuperTask() == null;
    }

    private void makeTreePrefixes() {
        if (isLastOfParent(task)) {
            builder.append("└ ");
        } else {
            builder.append("├ ");
        }

        Task parent = task.getSuperTask();

        while (parent != null) {
            if (!isRoot(parent)) {
                if (isLastOfParent(parent)) {
                    builder.insert(0, "  ");
                } else {
                    builder.insert(0, "│ ");
                }
            }

            parent = parent.getSuperTask();
        }
    }

    private boolean isLastOfParent(Task task) {
        Task parent = task.getSuperTask();

        if (parent == null)
            return true;

        Task lastOfParent = getLastSubTask(parent);

        if (lastOfParent == null)
            return true;

        return lastOfParent.equals(task);
    }

    private Task getLastSubTask(Task parent) {
        int initialIndex = tasks.indexOf(parent) + 1;

        Task lastSubTask = null;

        for (int i = initialIndex; i < tasks.size(); i++) {
            Task candidate = tasks.get(i);

            Task candidateParent = candidate.getSuperTask();

            if ((candidateParent != null) && (candidateParent.equals(parent)))
                lastSubTask = candidate;
        }

        return lastSubTask;
    }

}
