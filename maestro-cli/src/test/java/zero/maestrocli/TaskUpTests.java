package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.sysoutwrapper.SysoutWrapper;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskUpTests extends MaestrocliTest {

    private SysoutWrapper sysoutWrapper;

    @Before
    public void setup() {
        sysoutWrapper = new SysoutWrapper();
        System.setOut(sysoutWrapper);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_task_name() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "2", "--name=New task name");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #2:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Name: \"Test task #2\" -> \"New task name\""));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_supertask() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "2", "--supertaskid=1");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #2:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Supertask: <none> -> \"Test task #1\""));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_try_update_to_a_invalid_supertask() {
        try {
            controller.run("task", "up", "2", "--supertaskid=45");
            fail("Exception expected");
        } catch (Throwable e) {
            assertThat(e, is(notNullValue()));
            assertThat(e, instanceOf(EasyMVCException.class));
            assertThat(e.getMessage(), is("java.lang.RuntimeException: Supertask id #45 not found."));
        }
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_task_with_new_tags_and_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "2", "--tags=important,note:Note of task");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #2:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Tags: [] -> [important,note]"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_task_and_existing_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--tags=quick,note:New note on task #3");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #3:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Tags: [important,note] -> [important,note,quick]"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_remove_tags_from_task() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--removetags=important,note");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #3:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Tags: [important,note] -> []"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_remove_just_one_property_from_tag() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--removetags=note[creation]");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(2));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Task #3:"));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Tags: [important,note] -> [important,note] (property changed?)"));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_get_property_value_from_file() throws EasyMVCException, FileNotFoundException, SQLException, DatabaseUnitException, MalformedURLException {
        File file = new File("notefile");

        try {
            PrintStream p = new PrintStream(file);

            p.println("Note");
            p.println("from");
            p.println("file");

            p.close();

            controller.run("task", "up", "1", "--tags=note:@notefile");

            IDataSet databaseDataSet = getDBUnitDataset();
            ITable actualTaskTag = databaseDataSet.getTable("tasktag");
            ITable actualProperty = databaseDataSet.getTable("property");

            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_get_property_value_from_file__expecteddata.xml"));
            ITable expectedTaskTag = expectedDataSet.getTable("tasktag");
            ITable expectedProperty = expectedDataSet.getTable("property");

            Assertion.assertEquals(expectedTaskTag, actualTaskTag);
            Assertion.assertEquals(expectedProperty, actualProperty);
        } finally {
            file.delete();
        }

    }
}