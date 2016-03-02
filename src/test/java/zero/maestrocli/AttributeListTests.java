package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Tag;
import zero.utils.test.DBUnitDatasetFileNames;

public class AttributeListTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/AttributeListTests__should_list_a_tag_attributes.xml")
    public void should_list_a_tag_attributes() throws EasyMVCException {
        List<Object> beans = controller.run("attr", "ls", "uma_tag");

        EasyMVCAssert.assertBeanList(beans, 1);

        Tag tag = EasyMVCAssert.assertAndGetBean(beans, 0, Tag.class);

        Assert.assertTag("uma_tag", tag);
        Assert.assertTagAttributes(new String[] { "note", "place", "schedule" }, new String[] { "text", "gps", "datetime" }, tag);
    }
}
