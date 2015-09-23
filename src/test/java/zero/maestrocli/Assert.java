package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import zero.maestro.model.Tag;
import zero.maestro.model.TagAttribute;
import zero.maestro.model.Task;

class Assert {

    public static void assertTask(String expectedName, String superTaskName, Task actualTask) {
        assertNotNull(actualTask);
        assertEquals(expectedName, actualTask.getName());

        if (superTaskName == null)
            assertNull(actualTask.getSuperTask());
        else {
            Task superTask = actualTask.getSuperTask();

            assertNotNull(superTask);
            assertEquals(superTaskName, superTask.getName());
        }
    }

    public static void assertTag(String expectedName, Tag actualTag) {
        assertNotNull(actualTag);
        assertEquals(expectedName, actualTag.getName());
    }

    public static void assertTagAttributes(Tag actualTag, String... expectedAttributeNames) {
        assertNotNull(actualTag);

        List<TagAttribute> attributes = actualTag.getAttributes();
        assertNotNull(attributes);
        assertTrue(expectedAttributeNames.length == attributes.size());

        for (int i = 0; i < expectedAttributeNames.length; i++) {
            String expectedAttributeName = expectedAttributeNames[i];

            TagAttribute tagAttribute = attributes.get(i);
            assertNotNull(tagAttribute);
            assertEquals(expectedAttributeName, tagAttribute.getName());
        }
    }
}
