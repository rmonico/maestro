package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(3));

        Assert.assertTask("A third task", null, tasks.get(0));
        Assert.assertTask("Second task", null, tasks.get(1));
        Assert.assertTask("First task ever", null, tasks.get(2));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_subtasks_by_default.xml")
    public void should_list_subtasks_by_default() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(40));

        Assert.assertTask("Parent #11", null, tasks.get(0));
        Assert.assertTask("Parent #10", null, tasks.get(1));
        Assert.assertTask("Parent #10, sub #2", "Parent #10", tasks.get(2));
        Assert.assertTask("Parent #10, sub #1", "Parent #10", tasks.get(3));
        Assert.assertTask("Parent #10, sub #1, sub #1", "Parent #10, sub #1", tasks.get(4));
        Assert.assertTask("Parent #10, sub #1, sub #2", "Parent #10, sub #1", tasks.get(5));
        Assert.assertTask("Parent #10, sub #1, sub #4", "Parent #10, sub #1", tasks.get(6));
        Assert.assertTask("Parent #10, sub #1, sub #3", "Parent #10, sub #1", tasks.get(7));
        Assert.assertTask("Parent #9", null, tasks.get(8));
        Assert.assertTask("Parent #8", null, tasks.get(9));
        Assert.assertTask("Parent #8, sub #1", "Parent #8", tasks.get(10));
        Assert.assertTask("Parent #8, sub #1, sub #2", "Parent #8, sub #1", tasks.get(11));
        Assert.assertTask("Parent #8, sub #1, sub #1", "Parent #8, sub #1", tasks.get(12));
        Assert.assertTask("Parent #8, sub #1, sub #3", "Parent #8, sub #1", tasks.get(13));
        Assert.assertTask("Parent #7", null, tasks.get(14));
        Assert.assertTask("Parent #7, sub #4", "Parent #7", tasks.get(15));
        Assert.assertTask("Parent #7, sub #3", "Parent #7", tasks.get(16));
        Assert.assertTask("Parent #7, sub #2", "Parent #7", tasks.get(17));
        Assert.assertTask("Parent #7, sub #2, sub #1", "Parent #7, sub #2", tasks.get(18));
        Assert.assertTask("Parent #7, sub #2, sub #2", "Parent #7, sub #2", tasks.get(19));
        Assert.assertTask("Parent #7, sub #2, sub #3", "Parent #7, sub #2", tasks.get(20));
        Assert.assertTask("Parent #7, sub #1", "Parent #7", tasks.get(21));
        Assert.assertTask("Parent #7, sub #1, sub #1", "Parent #7, sub #1", tasks.get(22));
        Assert.assertTask("Parent #7, sub #1, sub #2", "Parent #7, sub #1", tasks.get(23));
        Assert.assertTask("Parent #7, sub #1, sub #3", "Parent #7, sub #1", tasks.get(24));
        Assert.assertTask("Parent #7, sub #1, sub #4", "Parent #7, sub #1", tasks.get(25));
        Assert.assertTask("Parent #6", null, tasks.get(26));
        Assert.assertTask("Parent #5", null, tasks.get(27));
        Assert.assertTask("Parent #4", null, tasks.get(28));
        Assert.assertTask("Parent #4, sub #4", "Parent #4", tasks.get(29));
        Assert.assertTask("Parent #4, sub #1", "Parent #4", tasks.get(30));
        Assert.assertTask("Parent #4, sub #2", "Parent #4", tasks.get(31));
        Assert.assertTask("Parent #4, sub #3", "Parent #4", tasks.get(32));
        Assert.assertTask("Parent #3", null, tasks.get(33));
        Assert.assertTask("Parent #3, sub #1", "Parent #3", tasks.get(34));
        Assert.assertTask("Parent #3, sub #2", "Parent #3", tasks.get(35));
        Assert.assertTask("Parent #3, sub #3", "Parent #3", tasks.get(36));
        Assert.assertTask("Parent #3, sub #4", "Parent #3", tasks.get(37));
        Assert.assertTask("Parent #1", null, tasks.get(38));
        Assert.assertTask("Parent #2", null, tasks.get(39));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_subtasks_by_default.xml")
    public void should_not_list_subtasks() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--nosubtasks");

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(11));

        Assert.assertTask("Parent #11", null, tasks.get(0));
        Assert.assertTask("Parent #10", null, tasks.get(1));
        Assert.assertTask("Parent #9", null, tasks.get(2));
        Assert.assertTask("Parent #8", null, tasks.get(3));
        Assert.assertTask("Parent #7", null, tasks.get(4));
        Assert.assertTask("Parent #6", null, tasks.get(5));
        Assert.assertTask("Parent #5", null, tasks.get(6));
        Assert.assertTask("Parent #4", null, tasks.get(7));
        Assert.assertTask("Parent #3", null, tasks.get(8));
        Assert.assertTask("Parent #1", null, tasks.get(9));
        Assert.assertTask("Parent #2", null, tasks.get(10));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_only_tasks_of_selected_tags.xml")
    public void should_list_only_tasks_of_selected_tags() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--tags=important,buy");

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(3));

        Assert.assertTask("Something not import to buy", null, tasks.get(0));
        Assert.assertTask("Something import to buy", null, tasks.get(1));
        Assert.assertTask("Something important", null, tasks.get(2));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_only_task_with_some_of_words_in_parameter.xml")
    public void should_list_only_task_with_some_of_words_in_parameter() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--with=first,Different");

        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(3));

        Assert.assertTask("First task with different and first words", null, tasks.get(0));
        Assert.assertTask("Second task with different word", null, tasks.get(1));
        Assert.assertTask("First task", null, tasks.get(2));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_only_tasks_with_all_of_word_in_parameter.xml")
    public void should_list_only_tasks_with_all_of_word_in_parameter() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--with-all=with,love");
        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(1));

        Assert.assertTask("With love from me to you", null, tasks.get(0));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_list_taks_by_id.xml")
    public void should_list_taks_by_id() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--ids=2,3");
        EasyMVCAssert.assertBeanList(beans, 2);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertThat("Task count", tasks.size(), is(2));

        Assert.assertTask("Task #3", null, tasks.get(0));
        Assert.assertTask("Task #2", null, tasks.get(1));
    }

}