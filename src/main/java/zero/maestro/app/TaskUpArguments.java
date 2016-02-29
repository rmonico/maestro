package zero.maestro.app;

import zero.easymvc.PositionalParameter;
import zero.easymvc.StringArrayParser;
import zero.easymvc.TokenParameter;

public class TaskUpArguments {

    @PositionalParameter
    private Integer taskId;

    @TokenParameter(token = { "-n", "--name" })
    private String name;

    @TokenParameter(token = { "-s", "--supertaskid" })
    private Integer supertaskID;

    @TokenParameter(token = { "-t", "--tags" }, parser = StringArrayParser.class)
    private String[] tags;

    @TokenParameter(token = { "-rt", "--removetags" }, parser = StringArrayParser.class)
    private String[] tagsToRemove;

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

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getTagsToRemove() {
        return tagsToRemove;
    }

    public void setTagsToRemove(String[] tagsToRemove) {
        this.tagsToRemove = tagsToRemove;
    }

}
