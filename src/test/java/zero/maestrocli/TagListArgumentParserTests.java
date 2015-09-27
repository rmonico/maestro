package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import zero.maestro.app.TagListArgumentParser;

public class TagListArgumentParserTests {

    @Test
    public void should_parse_a_single_tag() {
        TagListArgumentParser parser = new TagListArgumentParser();

        parser.parse("the_tag");

        assertEquals("the_tag", parser.getTagName());
    }
}
