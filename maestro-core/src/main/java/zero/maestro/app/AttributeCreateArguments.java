package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class AttributeCreateArguments {

    @PositionalParameter
    private String tagName;

    @PositionalParameter
    private String attributeName;

    @PositionalParameter
    private String attributeType;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

}
