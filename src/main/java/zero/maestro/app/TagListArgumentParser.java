package zero.maestro.app;

import java.util.LinkedList;
import java.util.List;

public class TagListArgumentParser {

    private static final Character LIST_BEGIN_CHAR = '[';
    private static final Character LIST_END_CHAR = ']';
    private static final Character PROPERTY_ASSIGN_CHARACTER = ':';

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

        attributeList = new LinkedList<ArgumentAttribute>();

        if (listData.isEmpty())
            return;

        int indexOfPropertyAssign = listData.indexOf(PROPERTY_ASSIGN_CHARACTER);

        String attributeName = listData.substring(0, indexOfPropertyAssign);

        String attributeValue = listData.substring(indexOfPropertyAssign + 1);

        ArgumentAttribute attribute = new ArgumentAttribute();

        attribute.setName(attributeName);

        attribute.setValue(attributeValue);

        attributeList.add(attribute);
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
