package zero.maestro.app;

import zero.easymvc.StringArrayParser;
import zero.easymvc.TokenParameter;

public class TaskListArguments {

    @TokenParameter(token = { "-t", "--tags" }, parser = StringArrayParser.class)
    private String[] tags;

    @TokenParameter(token = { "-w", "--with" }, parser = StringArrayParser.class)
    private String[] withSomeOfTheseWords;

    @TokenParameter(token = { "-wa", "--with-all" }, parser = StringArrayParser.class)
    private String[] withAllOfTheseWords;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String[] getWithSomeOfTheseWords() {
        return withSomeOfTheseWords;
    }

    public void setWithSomeOfTheseWords(String[] withSomeOfTheseWords) {
        this.withSomeOfTheseWords = withSomeOfTheseWords;
    }

    public String[] getWithAllOfTheseWords() {
        return withAllOfTheseWords;
    }

    public void setWithAllOfTheseWords(String[] withAllOfTheseWords) {
        this.withAllOfTheseWords = withAllOfTheseWords;
    }

}
