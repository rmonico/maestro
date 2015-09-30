package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;
import zero.utils.test.DBUnitDatasetFileNames;

import com.j256.ormlite.dao.ForeignCollection;

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

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskCreateTests__should_create_a_task_with_a_single_tag.xml")
    public void should_create_a_task_with_a_single_tag() throws Exception {
        controller.run("task", "add", "First tagged task ever", "--tags=important");

        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> taskList = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(1, taskList.size());

        Task task = taskList.get(0);

        Assert.assertTask("First tagged task ever", null, task);

        List<Tag> tagList = new LinkedList<Tag>();

        for (TaskTag taskTag : task.getTaskTags())
            tagList.add(taskTag.getTag());

        Assert.assertTaskTags(new String[] { "important" }, tagList);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskCreateTests_should_create_a_task_with_note.xml")
    public void should_create_a_task_with_note() throws Exception {
        controller.run("task", "add", "Task with note", "--tags=note:Nota da tarefa");

        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> taskList = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(1, taskList.size());

        Task task = taskList.get(0);

        Assert.assertTask("Task with note", null, task);

        ForeignCollection<TaskTag> taskTags = task.getTaskTags();

        assertNotNull(taskTags);
        assertEquals(1, taskTags.size());

        TaskTag noteTaskTag = taskTags.iterator().next();

        ForeignCollection<Property> properties = noteTaskTag.getProperties();

        assertNotNull(properties);
        assertEquals(1, properties.size());

        Property noteDefaultProperty = properties.iterator().next();

        assertEquals("Nota da tarefa", noteDefaultProperty.getValue());
    }

    @Test(expected = EasyMVCException.class)
    public void should_throw_exception_when_try_to_create_a_task_with_non_existing_tag() throws EasyMVCException {
        try {
            controller.run("task", "add", "Task with note", "--tags=note:Nota da tarefa");
        } catch (EasyMVCException e) {
            assertEquals(EasyMVCException.class, e.getClass());
            assertEquals("zero.easymvc.EasyMVCException: Unknown tag: \"note\".", e.getMessage());

            throw e;
        }
    }

    @Test(expected = EasyMVCException.class)
    @DBUnitDatasetFileNames("dbunit/TaskCreateTests_should_create_a_task_with_note.xml")
    public void should_throw_exception_when_try_to_create_a_task_with_non_existing_attribute() throws EasyMVCException {
        try {
            controller.run("task", "add", "Task with note", "--tags=note[attrib:Nota da tarefa]");
        } catch (EasyMVCException e) {
            assertEquals(EasyMVCException.class, e.getClass());
            assertEquals("zero.easymvc.EasyMVCException: Unknown attribute: \"attrib\" on tag \"note\".", e.getMessage());

            throw e;
        }
    }
}
