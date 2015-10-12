package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Task;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskListTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_all_three_tasks.xml")
    public void should_list_all_three_tasks() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tasks.size());

        Assert.assertTask("First task ever", null, tasks.get(0));
        Assert.assertTask("Second task", null, tasks.get(1));
        Assert.assertTask("A third task", null, tasks.get(2));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_task_with_supertask.xml")
    public void should_list_task_with_supertask() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(2, tasks.size());

        Assert.assertTask("A supertask", null, tasks.get(0));
        Assert.assertTask("A task with supertask", "A supertask", tasks.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_only_tasks_of_selected_tags.xml")
    public void should_list_only_tasks_of_selected_tags() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--tags=important,buy");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tasks.size());

        Assert.assertTask("Something important", null, tasks.get(0));
        Assert.assertTask("Something import to buy", null, tasks.get(1));
        Assert.assertTask("Something not import to buy", null, tasks.get(2));
    }
}
