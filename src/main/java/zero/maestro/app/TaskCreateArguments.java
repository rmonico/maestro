package zero.maestro.app;

import zero.easymvc.PositionalParameter;
import zero.easymvc.TokenParameter;

public class TaskCreateArguments {

    @PositionalParameter
    private String taskName;

    @TokenParameter(token = { "-s", "--supertaskid" })
    private Integer superTaskID;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getSuperTaskID() {
        return superTaskID;
    }

    public void setSuperTaskID(Integer superTaskID) {
        this.superTaskID = superTaskID;
    }

}
