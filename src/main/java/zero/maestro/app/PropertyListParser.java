package zero.maestro.app;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PropertyListParser {

    private static final Character LIST_BEGIN_CHAR = '[';
    private static final Character LIST_END_CHAR = ']';
    private static final Character PROPERTY_ASSIGN_CHAR = ':';
    private static final String PROPERTY_SEPARATOR_CHAR = ";";

    private String tagName;

    private List<ArgumentAttribute> attributeList;
    private List<String> errors;
    private String defaultAttributeName;

    public PropertyListParser() {
        errors = new LinkedList<String>();

        attributeList = new LinkedList<ArgumentAttribute>();
    }

    public void parse(final String arguments) throws IOException {
        int indexOfListBegin = arguments.indexOf(LIST_BEGIN_CHAR);

        parseTagNameAndDefaultAttributeValue(arguments, indexOfListBegin);

        if (indexOfListBegin == -1)
            return;

        int indexOfListEnd = arguments.indexOf(LIST_END_CHAR);

        if (indexOfListEnd == -1) {
            addError("List end character not found.");

            indexOfListEnd = arguments.length();
        }

        String listData = arguments.substring(indexOfListBegin + 1, indexOfListEnd);

        parseAttributeList(listData);
    }

    private void parseTagNameAndDefaultAttributeValue(final String arguments, final int indexOfListBegin) throws IOException {
        int indexOfFirstAssignment = arguments.indexOf(PROPERTY_ASSIGN_CHAR);

        if (indexOfListBegin == -1) {
            if (indexOfFirstAssignment > -1) {
                tagName = arguments.substring(0, indexOfFirstAssignment);

                String defaultAttributeValue = arguments.substring(indexOfFirstAssignment + 1, arguments.length());

                attributeList.add(new ArgumentAttribute(defaultAttributeName, defaultAttributeValue));
            } else
                tagName = arguments;

            return;
        }

        if ((indexOfFirstAssignment < indexOfListBegin) && (indexOfFirstAssignment > -1)) {
            tagName = arguments.substring(0, indexOfFirstAssignment);

            String defaultAttributeValue = arguments.substring(indexOfFirstAssignment + 1, indexOfListBegin);

            attributeList.add(new ArgumentAttribute(defaultAttributeName, defaultAttributeValue));
        } else
            tagName = arguments.substring(0, indexOfListBegin);
    }

    private void parseAttributeList(String listData) throws IOException {
        if (listData.isEmpty())
            return;

        int propertyEnd = -1;

        while (propertyEnd < listData.length()) {
            int lastPropertyEnd = propertyEnd;

            propertyEnd = listData.indexOf(PROPERTY_SEPARATOR_CHAR, propertyEnd + 1);

            if (propertyEnd == -1)
                propertyEnd = listData.length();

            String propertyData = listData.substring(lastPropertyEnd + 1, propertyEnd);

            parseAttribute(propertyData);
        }
    }

    private void parseAttribute(String propertyData) throws IOException {
        int indexOfAssign = propertyData.indexOf(PROPERTY_ASSIGN_CHAR);

        String attributeName;
        String attributeValue;

        if (indexOfAssign == -1) {
            addError(String.format("Assignment not found for attribute \"%s\".", propertyData));

            attributeName = propertyData;
            attributeValue = "";
        } else {
            attributeName = propertyData.substring(0, indexOfAssign);
            attributeValue = propertyData.substring(indexOfAssign + 1);
        }

        attributeList.add(new ArgumentAttribute(attributeName, attributeValue));
    }

    private void addError(String message) {
        errors.add(message);
    }

    public String getTagName() {
        return tagName;
    }

    public List<ArgumentAttribute> getAttributes() {
        return attributeList;
    }

    public void setDefaultAttributeName(String defaultAttributeName) {
        this.defaultAttributeName = defaultAttributeName;
    }

    public List<String> getErrors() {
        return errors;
    }
}
