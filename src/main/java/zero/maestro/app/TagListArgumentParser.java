package zero.maestro.app;

public class TagListArgumentParser {

    private String tagName;

    public void parse(String arguments) {
        tagName = arguments;
    }

    public String getTagName() {
        return tagName;
    }

}
