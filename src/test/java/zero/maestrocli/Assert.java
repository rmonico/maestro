package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import zero.maestro.model.Tag;
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

}
