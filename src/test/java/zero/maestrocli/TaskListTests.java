package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Task;

public class TaskListTests extends MaestrocliTest {

    public TaskListTests() {
        super("dbunit/tasklist_dataset.xml");
    }

    @Test
    public void should_list_all_three_tasks() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 1);

        @SuppressWarnings("unchecked")
        List<Task> tasks = EasyMVCAssert.assertAndGetBean(beans, 0, List.class);

        assertEquals(3, tasks.size());

        Assert.assertTask("First task ever", tasks.get(0));
        Assert.assertTask("Second task", tasks.get(1));
        Assert.assertTask("A third task", tasks.get(2));
    }

}
