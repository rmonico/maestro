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
        int indexOfListBegin = arguments.indexOf(LIST_BEGIN);

        attributes = new LinkedList<String>();

        if (indexOfListBegin == -1) {
            tagName = arguments;
            return;
        }

        tagName = arguments.substring(0, indexOfListBegin);

        int indexOfListEnd = arguments.indexOf(LIST_END);

        if (indexOfListEnd == -1)
            indexOfListEnd = arguments.length();

        String attributeList = arguments.substring(indexOfListBegin + 1, indexOfListEnd);

        if (attributeList.isEmpty())
            return;

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
