package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVC;
import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.TaskListCommand;
import zero.maestro.model.Task;
import zero.maestrocli.renderer.TaskListRenderer;

public class TaskListTests {

    private EasyMVC controller;

    @Before
    public void setup() {
        controller = new EasyMVC();

        registerCommandsAndRenderers();
    }

    private void registerCommandsAndRenderers() {
        controller.registerCommandHandler(TaskListCommand.class);
        controller.registerRenderer(TaskListRenderer.class);
    }

    @Test
    public void should_list_all_three_tasks() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tasks.size());

        assertTask("First task ever", tasks.get(0));
        assertTask("Second task", tasks.get(1));
        assertTask("A third task", tasks.get(2));
    }

    private void assertTask(String expectedName, Task actualTask) {
        assertNotNull(actualTask);
        assertEquals(expectedName, actualTask.getName());

        // TODO: assert super task
        assertNull(actualTask.getSuperTask());
    }
}
