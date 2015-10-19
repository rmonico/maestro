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

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_tags_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=tags");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| sometag, othertag |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| Tags              |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_properties_of_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=propertiesof:sometag");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| [attr:value of attr in sometag on 'Test task';date:30/Mai/2015] |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| #sometag                                                        |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_property_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=property:othertag.someattr");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| Value of someattr in othertag on 'Test task' |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| #othertag:someattr                           |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_every_possible_columns_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=id,name,subtaskcount,tags,tagcount,propertiesof:sometag,property:othertag.someattr");

        String expectedHeaderLine = "| ID | Name      | #Tasks | Tags              | #Tags | #sometag                                                        | #othertag:someattr                           |";
        String expectedDataLine = "| #1 | Test task | 8      | sometag, othertag | 2     | [attr:value of attr in sometag on 'Test task';date:30/Mai/2015] | Value of someattr in othertag on 'Test task' |";

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", expectedDataLine, wrapper.capturedLines.get(3));
        assertEquals("Header line", expectedHeaderLine, wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_no_tag_tasks.xml")
    public void should_render_no_tag_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=name,tags");

        String expectedHeaderLine = "| Name      | Tags |";
        String expectedDataLine = "| Test task |      |";

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", expectedDataLine, wrapper.capturedLines.get(3));
        assertEquals("Header line", expectedHeaderLine, wrapper.capturedLines.get(1));
    }
}
