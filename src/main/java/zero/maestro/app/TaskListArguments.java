package zero.maestro.app;

import zero.easymvc.StringArrayParser;
import zero.easymvc.TokenParameter;

public class TaskListArguments {

    @TokenParameter(token = { "-t", "--tags" }, parser = StringArrayParser.class)
    private String[] tags;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

}
