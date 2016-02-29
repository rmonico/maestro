package zero.maestro.app;

import java.util.LinkedList;
import java.util.List;

public class AttributeListParser {

    private static final Character LIST_BEGIN = '[';
    private static final Character LIST_END = ']';
    private static final Character ATTRIBUTE_SEPARATOR = ';';
    private String tagName;
    private LinkedList<String> attributes;

    // private LinkedList<String> errors;

    public void parse(final String arguments) {
        attributes = new LinkedList<String>();

        int indexOfListBegin = arguments.indexOf(LIST_BEGIN);

        if (parseTagName(arguments, indexOfListBegin))
            return;

        String attributeList = parseRawAttributeList(arguments, indexOfListBegin);

        if (attributeList.isEmpty())
            return;

        parseAttributeList(attributeList);
    }

    private boolean parseTagName(final String arguments, int indexOfListBegin) {
        if (indexOfListBegin == -1) {
            tagName = arguments;
            return true;
        }

        tagName = arguments.substring(0, indexOfListBegin);

        return false;
    }

    private String parseRawAttributeList(final String arguments, int indexOfListBegin) {
        int indexOfListEnd = arguments.indexOf(LIST_END);

        if (indexOfListEnd == -1)
            indexOfListEnd = arguments.length();

        return arguments.substring(indexOfListBegin + 1, indexOfListEnd);
    }

    private void parseAttributeList(String attributeList) {
        int attributeEnd = -1;

        while (attributeEnd < attributeList.length()) {
            int attributeStart = attributeEnd + 1;

            attributeEnd = attributeList.indexOf(ATTRIBUTE_SEPARATOR, attributeStart);

            if (attributeEnd == -1)
                attributeEnd = attributeList.length();

            String attributeName = attributeList.substring(attributeStart, attributeEnd);

            attributes.add(attributeName);
        }
    }

    public String getTagName() {
        return tagName;
    }

    public List<String> getAttributes() {
        return attributes;
    }

}
