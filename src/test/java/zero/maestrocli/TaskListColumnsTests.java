package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskListColumnsTests extends MaestrocliTest {

    private SysoutWrapper wrapper;

    @Before
    public void setup() {
        wrapper = new SysoutWrapper();
        System.setOut(wrapper);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_id_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=id");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| ID |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| #1 |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_name_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=name");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| Name      |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| Test task |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_subtaskcount_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=subtaskcount");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| #Tasks |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| 8      |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_tagcount_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=tagcount");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| #Tags |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| 2     |", wrapper.capturedLines.get(3));
    }


}
