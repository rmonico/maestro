package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import zero.maestro.app.ArgumentAttribute;
import zero.maestro.app.TagListArgumentParseException;
import zero.maestro.app.TagListArgumentParser;

public class TagListArgumentParserTests {

    TagListArgumentParser parser;

    @Before
    public void before() {
        parser = new TagListArgumentParser();
    }

    @Test
    public void should_parse_a_single_tag() throws TagListArgumentParseException {
        parser.parse("the_tag");

        assertEquals("the_tag", parser.getTagName());
    }

    @Test
    public void should_parse_a_tag_with_empty_attribute_list() throws TagListArgumentParseException {
        parser.parse("tag[]");

        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertTrue("List empty", attributes.isEmpty());
    }

    private void assertAttribute(String message, String expectedName, String expectedValue, ArgumentAttribute actualAttribute) {
        assertEquals(String.format("%s name", message), expectedName, actualAttribute.getName());
        assertEquals(String.format("%s value", message), expectedValue, actualAttribute.getValue());
    }

    @Test
    public void should_parse_a_tag_with_one_attribute() throws TagListArgumentParseException {
        parser.parse("tag[attribute:value]");

        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 1, attributes.size());
        assertAttribute("Attribute", "attribute", "value", attributes.get(0));
    }

    @Test
    public void should_parse_a_tag_with_more_than_one_attribute() throws TagListArgumentParseException {
        parser.parse("tag[first:value of first;second_attribute:second's value;terceiro:valor do terceiro]");

        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 3, attributes.size());

        assertAttribute("Attribute 0", "first", "value of first", attributes.get(0));
        assertAttribute("Attribute 1", "second_attribute", "second's value", attributes.get(1));
        assertAttribute("Attribute 2", "terceiro", "valor do terceiro", attributes.get(2));
    }
}
