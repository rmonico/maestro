package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import zero.maestro.app.ArgumentAttribute;
import zero.maestro.app.PropertyListParser;

public class PropertyListParserTests {

    PropertyListParser parser;

    @Before
    public void before() {
        parser = new PropertyListParser();

        parser.setDefaultAttributeName("default");
    }

    @Test
    public void should_parse_a_single_tag() throws IOException {
        parser.parse("the_tag");

        assertEquals("the_tag", parser.getTagName());
    }

    @Test
    public void should_parse_a_tag_with_empty_attribute_list() throws IOException {
        parser.parse("tag[]");

        assertTrue("No error", parser.getErrors().isEmpty());
        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertTrue("List empty", attributes.isEmpty());
    }

    private void assertAttribute(String message, String expectedName, String expectedValue, ArgumentAttribute actualAttribute) {
        assertEquals(String.format("%s name", message), expectedName, actualAttribute.getName());
        assertEquals(String.format("%s value", message), expectedValue, actualAttribute.getValue());
    }

    @Test
    public void should_parse_a_tag_with_one_attribute() throws IOException {
        parser.parse("tag[attribute:value]");

        assertTrue("No error", parser.getErrors().isEmpty());
        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 1, attributes.size());
        assertAttribute("Attribute", "attribute", "value", attributes.get(0));
    }

    @Test
    public void should_parse_a_tag_with_more_than_one_attribute() throws IOException {
        parser.parse("tag[first:value of first;second_attribute:second's value;terceiro:valor do terceiro]");

        assertTrue("No error", parser.getErrors().isEmpty());
        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 3, attributes.size());

        assertAttribute("Attribute 0", "first", "value of first", attributes.get(0));
        assertAttribute("Attribute 1", "second_attribute", "second's value", attributes.get(1));
        assertAttribute("Attribute 2", "terceiro", "valor do terceiro", attributes.get(2));
    }

    @Test
    public void should_parse_a_tag_with_default_attribute_only() throws IOException {
        parser.parse("tag:default attribute's value");

        assertTrue("No error", parser.getErrors().isEmpty());
        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 1, attributes.size());

        assertAttribute("Default attribute", "default", "default attribute's value", attributes.get(0));
    }

    @Test
    public void should_parse_a_tag_with_default_and_more_than_one_attribute() throws IOException {
        parser.parse("tag:default attribute's value[first_non_default_attribute:property;second:value of second]");

        assertTrue("No error", parser.getErrors().isEmpty());
        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 3, attributes.size());

        assertAttribute("Default attribute", "default", "default attribute's value", attributes.get(0));
        assertAttribute("Attribute 1", "first_non_default_attribute", "property", attributes.get(1));
        assertAttribute("Attribute 2", "second", "value of second", attributes.get(2));
    }

    @Test
    public void should_parse_a_non_closed_list() throws IOException {
        parser.parse("tag[attribute:value");

        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 1, attributes.size());
        assertAttribute("Attribute", "attribute", "value", attributes.get(0));

        List<String> errors = parser.getErrors();

        assertNotNull("List valid", errors);
        assertEquals("List size", 1, errors.size());
        assertEquals("Message name", "List end character not found.", errors.get(0));
    }

    @Test
    public void should_parse_unassigned_attribute() throws IOException {
        parser.parse("tag[attribute_name value_of_attribute;second:second_value]");

        assertEquals("Tag name", "tag", parser.getTagName());

        List<ArgumentAttribute> attributes = parser.getAttributes();
        assertEquals("Attributes size", 2, attributes.size());
        assertAttribute("Attribute 0", "attribute_name value_of_attribute", "", attributes.get(0));
        assertAttribute("Attribute 1", "second", "second_value", attributes.get(1));

        List<String> errors = parser.getErrors();

        assertNotNull("List valid", errors);
        assertEquals("List size", 1, errors.size());
        assertEquals("Message name", "Assignment not found for attribute \"attribute_name value_of_attribute\".", errors.get(0));
    }

}
