package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Tag;
import zero.utils.test.DBUnitDatasetFileNames;

public class TagListTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TagListTests__should_list_all_three_tags.xml")
    public void should_list_all_three_tags() throws EasyMVCException {
        List<Object> beans = controller.run("tag", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Tag> tags = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tags.size());

        Assert.assertTag("first_tag", tags.get(0));
        Assert.assertTag("second_tag", tags.get(1));
        Assert.assertTag("third_tag", tags.get(2));
    }

}
