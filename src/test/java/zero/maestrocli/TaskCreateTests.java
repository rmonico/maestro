package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Task;

public class TaskCreateTests extends MaestrocliTest {

    @Test
    public void should_create_a_new_task() throws EasyMVCException {
        List<Object> beans = controller.run("task", "add", "Some task");

        EasyMVCAssert.assertBeanList(beans, 1);

        Task task = EasyMVCAssert.assertAndGetBean(beans, 0, Task.class);

        Assert.assertTask("Some task", null, task);
    }

}
