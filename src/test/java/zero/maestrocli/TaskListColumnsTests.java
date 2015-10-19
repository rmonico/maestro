package zero.maestrocli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskListColumnsTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListTests__should_render_every_possible_columns_for_top_tasks.xml")
    public void should_render_every_possible_columns_for_top_tasks() throws EasyMVCException {
        SysoutWrapper wrapper = new SysoutWrapper();
        System.setOut(wrapper);

        controller.run("task", "ls", "--nosubtasks", "--columns=id,name,subtaskcount,tags,tagcount,attributesof:sometag,#othertag:someattr");

        String expectedHeaderLine = "| ID | Name      | #Subtasks | Tags             | #Tags | #sometag                                               | #othertag:someattr                       |";
        String expectedDataLine = "| #1 | Test task | 8         | sometag,othertag | 2     | [attr:value of attr in sometag on task #1;date:30/Mai] | Value of someattr in othertag on task #1 |";

        assertTrue("Line count", wrapper.capturedLines.size() > 5);
        assertEquals("Header line", expectedHeaderLine, wrapper.capturedLines.get(1));
        assertEquals("Data line", expectedDataLine, wrapper.capturedLines.get(3));
    }

}
