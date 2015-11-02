package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
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
    public void should_pass_columns_param_to_renderer() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--columns=id,name,supertask");

        EasyMVCAssert.assertBeanList(beans, 2);

        String[] columns = EasyMVCAssert.assertAndGetBean(beans, 1, String[].class);

        assertEquals("Length", 3, columns.length);
        assertEquals("id", columns[0]);
        assertEquals("name", columns[1]);
        assertEquals("supertask", columns[2]);
    }

    @Test
    public void should_pass_columns_from_properties_when_parameter_is_not_defined() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 2);

        String[] columns = EasyMVCAssert.assertAndGetBean(beans, 1, String[].class);

        assertEquals("Length", 2, columns.length);
        assertEquals("id", columns[0]);
        assertEquals("name", columns[1]);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_id_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=id");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| ID |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| #1 |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_name_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=name");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| Name      |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| Test task |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_supertask_column() throws EasyMVCException {
        controller.run("task", "ls", "--columns=supertask");

        assertThat("Line count", wrapper.capturedLines.size(), greaterThanOrEqualTo(13));
        assertThat("Header line", wrapper.capturedLines.get(1), is("| Supertask |"));
        assertThat("Data line #1", wrapper.capturedLines.get(3), is("| <null>    |"));
        assertThat("Data line #2", wrapper.capturedLines.get(4), is("| Test task |"));
        assertThat("Data line #3", wrapper.capturedLines.get(5), is("| Test task |"));
        assertThat("Data line #4", wrapper.capturedLines.get(6), is("| Test task |"));
        assertThat("Data line #5", wrapper.capturedLines.get(7), is("| Test task |"));
        assertThat("Data line #6", wrapper.capturedLines.get(8), is("| Test task |"));
        assertThat("Data line #7", wrapper.capturedLines.get(9), is("| Test task |"));
        assertThat("Data line #8", wrapper.capturedLines.get(10), is("| Test task |"));
        assertThat("Data line #9", wrapper.capturedLines.get(11), is("| Test task |"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_name_column_as_tree_for_sub_tasks.xml")
    public void should_render_name_column_as_tree_for_sub_tasks() throws EasyMVCException {
        controller.run("task", "ls");

        assertThat("Line count", wrapper.capturedLines.size(), greaterThanOrEqualTo(17));
        assertThat("Header line", wrapper.capturedLines.get(1), is("| ID  | Name                                    |"));
        assertThat("Data line #1", wrapper.capturedLines.get(3), is("| #1  | Parent #1                               |"));
        assertThat("Data line #2", wrapper.capturedLines.get(4), is("| #9  | ├ Parent #1, Sub #2                     |"));
        assertThat("Data line #3", wrapper.capturedLines.get(5), is("| #13 | │ ├ Parent #1, Sub #2, Sub #2           |"));
        assertThat("Data line #4", wrapper.capturedLines.get(6), is("| #15 | │ │ ├ Parent #1, Sub #2, Sub #2, Sub #2 |"));
        assertThat("Data line #5", wrapper.capturedLines.get(7), is("| #14 | │ │ └ Parent #1, Sub #2, Sub #2, Sub #1 |"));
        assertThat("Data line #6", wrapper.capturedLines.get(8), is("| #10 | │ └ Parent #1, Sub #2, Sub #1           |"));
        assertThat("Data line #7", wrapper.capturedLines.get(9), is("| #12 | │   ├ Parent #1, Sub #2, Sub #1, Sub #2 |"));
        assertThat("Data line #8", wrapper.capturedLines.get(10), is("| #11 | │   └ Parent #1, Sub #2, Sub #1, Sub #1 |"));
        assertThat("Data line #9", wrapper.capturedLines.get(11), is("| #2  | └ Parent #1, Sub #1                     |"));
        assertThat("Data line #10", wrapper.capturedLines.get(12), is("| #6  |   ├ Parent #1, Sub #1, Sub #2           |"));
        assertThat("Data line #11", wrapper.capturedLines.get(13), is("| #8  |   │ ├ Parent #1, Sub #1, Sub #2, Sub #2 |"));
        assertThat("Data line #12", wrapper.capturedLines.get(14), is("| #7  |   │ └ Parent #1, Sub #1, Sub #2, Sub #1 |"));
        assertThat("Data line #13", wrapper.capturedLines.get(15), is("| #3  |   └ Parent #1, Sub #1, Sub #1           |"));
        assertThat("Data line #14", wrapper.capturedLines.get(16), is("| #5  |     ├ Parent #1, Sub #1, Sub #1, Sub #2 |"));
        assertThat("Data line #15", wrapper.capturedLines.get(17), is("| #4  |     └ Parent #1, Sub #1, Sub #1, Sub #1 |"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_subtaskcount_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=subtaskcount");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| #Tasks |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| 8      |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_tagcount_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=tagcount");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", "| #Tags |", wrapper.capturedLines.get(1));
        assertEquals("Data line", "| 2     |", wrapper.capturedLines.get(3));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_tags_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=tags");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| sometag, othertag |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| Tags              |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_properties_of_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=propertiesof:sometag");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| [attr:value of attr in sometag on 'Test task';date:30/Mai/2015] |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| #sometag                                                        |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_property_column_for_top_tasks() throws EasyMVCException {
        controller.run("task", "ls", "--nosubtasks", "--columns=property:othertag.someattr");

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Data line", "| Value of someattr in othertag on 'Test task' |", wrapper.capturedLines.get(3));
        assertEquals("Header line", "| #othertag:someattr                           |", wrapper.capturedLines.get(1));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListColumnsTests__should_render_every_possible_columns_for_top_tasks.xml")
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
