package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Tag;

public class AttributeCreateTests extends MaestrocliTest {

    @Test
    public void should_create_a_text_attribute() throws EasyMVCException {
        controller.run("tag", "add", "a_tag");

        controller.run("attr", "add", "a_tag", "note", "TEXT");

        List<Object> beans = controller.run("tag", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Tag> tags = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(1, tags.size());

        Tag tag = tags.get(0);

        Assert.assertTag("a_tag", tag);
        Assert.assertTagAttributes(new String[] { "note" }, new String[] { "TEXT" }, tag);
    }
}
