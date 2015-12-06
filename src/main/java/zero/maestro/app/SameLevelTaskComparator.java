package zero.maestro.app;

import java.util.Comparator;

import zero.maestro.model.Task;

public class SameLevelTaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task, Task anotherTask) {
        // -1: task < anotherTask
        // 0: task = anotherTask
        // +1: task > anotherTask

        if (task.getSuperTask() == null) {
            int taskId = task.getId();
            int anotherTaskId = anotherTask.getId();

            return anotherTaskId - taskId;
        } else {
            String taskName = task.getName();
            String anotherTaskName = anotherTask.getName();

            return taskName.compareTo(anotherTaskName);
        }
    }

}
