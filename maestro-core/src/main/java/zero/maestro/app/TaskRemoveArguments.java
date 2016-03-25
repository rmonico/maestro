package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class TaskRemoveArguments {

    @PositionalParameter
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

}
