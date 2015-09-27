package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.utils.test.DBUnitDatasetFileNames;

import com.j256.ormlite.support.ConnectionSource;

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
        List<Object> beans = controller.run("task", "add", "First tagged task ever", "--tags=#important");

        EasyMVCAssert.assertBeanList(beans, 1);

        Task task = EasyMVCAssert.assertAndGetBean(beans, 0, Task.class);

        Assert.assertTask("First tagged task ever", null, task);

        ConnectionSource connection = connectionManager.getConnection();

        TagDao tagDao = (TagDao) daoManager.getInstance(TagDao.class);

        List<Tag> tags = TaskTagDao.getInstance(connection).getTags(tagDao, task.getId());

        Assert.assertTaskTags(new String[] { "important" }, tags);
    }
}
