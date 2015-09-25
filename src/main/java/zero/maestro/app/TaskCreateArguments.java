package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class TaskCreateArguments {

    @PositionalParameter
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
