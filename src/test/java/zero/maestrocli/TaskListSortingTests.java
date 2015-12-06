package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.sysoutwrapper.SysoutWrapper;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskListSortingTests extends MaestrocliTest {

    private SysoutWrapper sysoutWrapper;

    @Before
    public void setup() {
        sysoutWrapper = new SysoutWrapper();
        System.setOut(sysoutWrapper);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListSortingTests__should_sort_root_tasks_by_id_reversed.xml")
    public void should_sort_root_tasks_by_id_reversed() throws EasyMVCException {
        controller.run("task", "ls");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(4));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(3), is("| #3 | 115. Task id #3 |"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(4), is("| #2 | 45. Task id #2  |"));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(5), is("| #1 | 66. Task id #1  |"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskListSortingTests__should_sort_subtasks_by_name.xml")
    public void should_sort_subtasks_by_name() throws EasyMVCException {
        controller.run("task", "ls");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(4));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(3), is("| #3 | 115. Task id #3 |"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(4), is("| #2 | 45. Task id #2  |"));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(5), is("| #1 | 66. Task id #1  |"));
    }
}
