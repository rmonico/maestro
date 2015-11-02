package zero.maestrocli.renderer;

import java.util.Collection;
import java.util.Iterator;

import zero.listprinter.DataExtractor;
import zero.maestro.model.Task;

public class TaskNameAsTreeExtractor implements DataExtractor {

    private Task task;
    private StringBuilder builder;

    @Override
    public Object extract(Object data) {
        task = (Task) data;

        builder = new StringBuilder();

        if (!isRoot(task))
            makeTreePrefixes();

        builder.append(task.getName());

        return builder.toString();
    }

    private void makeTreePrefixes() {
        if (isLastInParent(task)) {
            builder.append("└ ");
        } else {
            builder.append("├ ");
        }

        Task parent = task.getSuperTask();

        while (parent != null) {
            if (isLastInParent(parent)) {
                builder.insert(0, "  ");
            } else {
                if (!isRoot(parent))
                    builder.insert(0, "│ ");
            }

            parent = parent.getSuperTask();
        }
    }

    private boolean isRoot(Task task) {
        return task.getSuperTask() == null;
    }

    private boolean isLastInParent(Task task) {
        Task parent = task.getSuperTask();

        if (parent == null)
            return false;

        Collection<Task> subTasks = parent.getSubTasks();

        Iterator<Task> iterator = subTasks.iterator();

        Task lastParentTask = null;

        while (iterator.hasNext()) {
            lastParentTask = iterator.next();
        }

        return lastParentTask.equals(task);
    }

}
