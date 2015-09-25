package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Task;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskCreateTests extends MaestrocliTest {

    @Test
    public void should_create_a_new_task() throws EasyMVCException {
        List<Object> beans = controller.run("task", "add", "Some task");

        EasyMVCAssert.assertBeanList(beans, 1);

        Task task = EasyMVCAssert.assertAndGetBean(beans, 0, Task.class);

        Assert.assertTask("Some task", null, task);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskCreateTests__should_create_a_new_task_with_supertask.xml")
    public void should_create_a_new_task_with_supertask() throws EasyMVCException {
        List<Object> beans = controller.run("task", "add", "A subtask", "--supertaskid=1");

        EasyMVCAssert.assertBeanList(beans, 1);

        Task task = EasyMVCAssert.assertAndGetBean(beans, 0, Task.class);

        Assert.assertTask("A subtask", "Super task", task);
    }
}
