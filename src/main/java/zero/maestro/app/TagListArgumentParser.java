package zero.maestro.app;

import java.util.LinkedList;
import java.util.List;

public class TagListArgumentParser {

    private static final Character LIST_BEGIN_CHAR = '[';
    private static final Character LIST_END_CHAR = ']';
    private static final Character PROPERTY_ASSIGN_CHAR = ':';
    private static final String PROPERTY_SEPARATOR_CHAR = ";";

    private String tagName;

    private List<ArgumentAttribute> attributeList;
    private List<String> errors;

    public void parse(String arguments) throws TagListArgumentParseException {
        errors = new LinkedList<String>();

        int indexOfListBegin = arguments.indexOf(LIST_BEGIN_CHAR);

        if (indexOfListBegin == -1) {
            tagName = arguments;
            return;
        }

        tagName = arguments.substring(0, indexOfListBegin);

        int indexOfListEnd = arguments.indexOf(LIST_END_CHAR);

        if (indexOfListEnd == -1)
            addFatalError("List end character not found.");

        String listData = arguments.substring(indexOfListBegin + 1, indexOfListEnd);

        parseAttributeList(listData);
    }

    private void parseAttributeList(String listData) {
        attributeList = new LinkedList<ArgumentAttribute>();

        if (listData.isEmpty())
            return;

        int propertyEnd = -1;

        while (propertyEnd < listData.length()) {
            int lastPropertyEnd = propertyEnd;

            propertyEnd = listData.indexOf(PROPERTY_SEPARATOR_CHAR, propertyEnd + 1);

            if (propertyEnd == -1)
                propertyEnd = listData.length();

            String propertyData = listData.substring(lastPropertyEnd + 1, propertyEnd);

            int indexOfAssign = propertyData.indexOf(PROPERTY_ASSIGN_CHAR);

            String attributeName = propertyData.substring(0, indexOfAssign);

            String attributeValue = propertyData.substring(indexOfAssign + 1);

            ArgumentAttribute attribute = new ArgumentAttribute(attributeName, attributeValue);

            attributeList.add(attribute);
        }
    }

    private void addFatalError(String message) throws TagListArgumentParseException {
        errors.add(message);

        throw new TagListArgumentParseException(message);
    }

    public String getTagName() {
        return tagName;
    }

    public List<ArgumentAttribute> getAttributes() {
        return attributeList;
    }

}
