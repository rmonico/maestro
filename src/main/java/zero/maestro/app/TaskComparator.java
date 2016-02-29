package zero.maestro.app;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import zero.maestro.model.Task;

public class TaskComparator implements Comparator<Task> {

    private Comparator<Task> sameLevelTaskComparator;
    private Task task;
    private Task anotherTask;
    private Task commonParentTask;
    private Task commonParentAnotherTask;
    private boolean anotherTaskIsParentOfTask;
    private boolean taskIsParentOfAnotherTask;

    public TaskComparator(Comparator<Task> sameLevelTaskComparator) {
        this.sameLevelTaskComparator = sameLevelTaskComparator;
    }

    @Override
    public int compare(Task task, Task anotherTask) {
        this.task = task;
        this.anotherTask = anotherTask;

        anotherTaskIsParentOfTask = false;
        taskIsParentOfAnotherTask = false;

        findCommonParentTasks();

        if (anotherTaskIsParentOfTask)
            return 1;
        else if (taskIsParentOfAnotherTask)
            return -1;
        else
            return sameLevelTaskComparator.compare(commonParentTask, commonParentAnotherTask);
    }

    private void findCommonParentTasks() {
        List<Task> parentsOfTask = getParentsOf(task);
        List<Task> parentsOfAnotherTask = getParentsOf(anotherTask);

        for (int i = 0; i < parentsOfTask.size(); i++) {
            Task taskParent = parentsOfTask.get(i);

            for (int j = 0; j < parentsOfAnotherTask.size(); j++) {
                Task anotherTaskParent = parentsOfAnotherTask.get(j);

                if (taskParent.equals(anotherTaskParent)) {
                    if (i == 0)
                        taskIsParentOfAnotherTask = true;
                    else
                        commonParentTask = parentsOfTask.get(i - 1);

                    if (j == 0)
                        anotherTaskIsParentOfTask = true;
                    else
                        commonParentAnotherTask = parentsOfAnotherTask.get(j - 1);

                    return;
                }
            }
        }

        commonParentTask = parentsOfTask.get(parentsOfTask.size() - 1);
        commonParentAnotherTask = parentsOfAnotherTask.get(parentsOfAnotherTask.size() - 1);
    }

    private List<Task> getParentsOf(Task task) {
        List<Task> parents = new LinkedList<Task>();

        Task parent = task;

        parents.add(task);

        while (parent.getSuperTask() != null) {
            parent = parent.getSuperTask();

            parents.add(parent);
        }

        return parents;
    }

}
