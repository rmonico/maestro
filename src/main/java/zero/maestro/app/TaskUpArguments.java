package zero.maestro.app;

import zero.easymvc.PositionalParameter;
import zero.easymvc.TokenParameter;

public class TaskUpArguments {

    @PositionalParameter
    private Integer taskId;

    @TokenParameter(token = { "-n", "--name" })
    private String name;

    @TokenParameter(token = { "-s", "--supertaskid" })
    private Integer supertaskID;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSupertaskID() {
        return supertaskID;
    }

    public void setSupertaskID(Integer supertaskID) {
        this.supertaskID = supertaskID;
    }

}
