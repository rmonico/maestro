package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Tag;

public class TagCreateTests extends MaestroTest {

    @Test
    public void should_create_a_new_tag() throws EasyMVCException {
        List<Object> beans = controller.run("tag", "add", "created_tag");

        EasyMVCAssert.assertBeanList(beans, 1);

        Tag tag = EasyMVCAssert.assertAndGetBean(beans, 0, Tag.class);

        Assert.assertTag("created_tag", tag);
    }

    @Test(expected = EasyMVCException.class)
    public void should_throw_exception_when_try_to_create_a_tag_with_invalid_name() throws EasyMVCException {
        controller.run("tag", "add", "tag with space in name");
    }
}
