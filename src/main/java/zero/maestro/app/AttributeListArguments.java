package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class AttributeListArguments {

    @PositionalParameter
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

}
