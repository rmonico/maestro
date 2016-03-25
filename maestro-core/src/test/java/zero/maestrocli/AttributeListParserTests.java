package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import zero.maestro.app.AttributeListParser;

public class AttributeListParserTests {

    private AttributeListParser parser;

    @Before
    public void before() {
        parser = new AttributeListParser();
    }

    @Test
    public void should_parse_tag_itself() {
        parser.parse("tag_name");

        assertThat("Tag name", parser.getTagName(), is("tag_name"));
        assertThat("Attributes", parser.getAttributes().isEmpty(), is(true));
    }

    @Test
    public void should_parse_tag_specific_attributes() {
        parser.parse("tag_name[attribute_1;attribute_2]");

        assertThat("Tag name", parser.getTagName(), is("tag_name"));
        assertThat("Attributes list size", parser.getAttributes().size(), is(2));
        assertThat("Attribute #1", parser.getAttributes().get(0), is("attribute_1"));
        assertThat("Attribute #2", parser.getAttributes().get(1), is("attribute_2"));
    }

    @Test
    public void should_parse_a_empty_attribute_list() {
        parser.parse("tag_name[]");

        assertThat("Tag name", parser.getTagName(), is("tag_name"));
        assertThat("Attributes list size", parser.getAttributes().size(), is(0));
    }

    @Test
    public void should_parse_a_non_closed_list() {
        parser.parse("tag_name[attribute1");

        assertThat("Tag name", parser.getTagName(), is("tag_name"));
        assertThat("Attributes list size", parser.getAttributes().size(), is(1));
        assertThat("Attribute #1", parser.getAttributes().get(0), is("attribute1"));
    }

    @Test
    public void should_parse_a_multi_attribute_non_closed_list() {
        parser.parse("tag_name[attribute1;attribute2");

        assertThat("Tag name", parser.getTagName(), is("tag_name"));
        assertThat("Attributes list size", parser.getAttributes().size(), is(2));
        assertThat("Attribute #1", parser.getAttributes().get(0), is("attribute1"));
        assertThat("Attribute #2", parser.getAttributes().get(1), is("attribute2"));
    }
}
