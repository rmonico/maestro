package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import zero.maestro.model.Task;

class Assert {

    public static void assertTask(String expectedName, Task actualTask) {
        assertNotNull(actualTask);
        assertEquals(expectedName, actualTask.getName());

        // TODO: assert super task
        assertNull(actualTask.getSuperTask());
    }

}
