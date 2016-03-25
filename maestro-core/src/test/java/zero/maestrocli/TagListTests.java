package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Tag;
import zero.utils.test.DBUnitDatasetFileNames;

public class TagListTests extends MaestroTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TagListTests__should_list_all_three_tags.xml")
    public void should_list_all_three_tags() throws EasyMVCException {
        List<Object> beans = controller.run("tag", "ls");

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Tag> tags = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tags.size());

        Assert.assertTag("first_tag", tags.get(0));
        Assert.assertTag("second_tag", tags.get(1));
        Assert.assertTag("third_tag", tags.get(2));
    }

    @SuppressWarnings("unchecked")
    @Test
    @DBUnitDatasetFileNames("dbunit/TagListTests__should_list_tags_with_task_counts.xml")
    public void should_list_tags_with_task_counts() throws EasyMVCException {
        List<Object> beans = controller.run("tag", "ls");

        EasyMVCAssert.assertBeanList(beans, 2);

        List<Tag> tags = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tags.size());

        Tag first_tag = tags.get(0);
        Tag second_tag = tags.get(1);
        Tag third_tag = tags.get(2);

        Assert.assertTag("first_tag", first_tag);
        Assert.assertTag("second_tag", second_tag);
        Assert.assertTag("third_tag", third_tag);

        Map<Tag, Integer> taskCount = EasyMVCAssert.assertAndGetBean(beans, 1, Map.class);

        assertEquals(new Integer(2), taskCount.get(first_tag));
        assertEquals(new Integer(4), taskCount.get(second_tag));
        assertEquals(new Integer(6), taskCount.get(third_tag));
    }

}
