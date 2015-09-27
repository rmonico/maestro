package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;

import com.j256.ormlite.dao.ForeignCollection;

class Assert {

    public static void assertTask(String expectedName, String expectedSuperTaskName, Task actualTask) {
        assertNotNull(actualTask);

        if (expectedSuperTaskName == null)
            assertNull(actualTask.getSuperTask());
        else {
            Task superTask = actualTask.getSuperTask();

            assertNotNull(superTask);
            assertEquals(expectedSuperTaskName, superTask.getName());
        }

        assertEquals(expectedName, actualTask.getName());
    }

    public static void assertTaskTags(String[] expectedTagNames, List<Tag> actualTags) {
        if (expectedTagNames == null)
            assertNull(actualTags);
        else {
            assertNotNull(actualTags);

            assertTrue(actualTags.size() == expectedTagNames.length);

            int i = 0;

            for (Tag actualTag : actualTags) {
                String expectedTagName = expectedTagNames[i];

                assertEquals(expectedTagName, actualTag.getName());

                i++;
            }
        }
    }

    public static void assertTag(String expectedName, Tag actualTag) {
        assertNotNull(actualTag);
        assertEquals(expectedName, actualTag.getName());
    }

    public static void assertTagAttributes(String[] expectedAttributeNames, String[] expectedAttributeTypes, Tag actualTag) {
        assertNotNull(actualTag);

        ForeignCollection<Attribute> attributes = actualTag.getAttributes();
        assertNotNull(attributes);
        assertTrue(expectedAttributeNames.length == attributes.size());
        assertTrue(expectedAttributeTypes.length == attributes.size());

        int i = 0;

        for (Attribute tagAttribute : attributes) {
            String expectedAttributeName = expectedAttributeNames[i];
            String expectedAttributeType = expectedAttributeTypes[i];

            assertNotNull(tagAttribute);
            assertEquals(expectedAttributeName, tagAttribute.getName());
            assertEquals(expectedAttributeType, tagAttribute.getType().toString());

            i++;
        }
    }
}
