package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class PropertySetterArguments {

    @PositionalParameter
    private int taskId;

    @PositionalParameter(after = "taskId")
    private String tagName;

    @PositionalParameter(after = "tagName")
    private String attributeName;

    @PositionalParameter(after = "attributeName")
    private String attributeValue;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

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

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

}
