package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.fail;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskUpTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_task_name() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "2", "--name=New task name");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_update_task_name__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_try_update_invalid_task() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        try {
            controller.run("task", "up", "45", "--name=New task name");
            fail("Exception expected");
        } catch (Throwable e) {
            assertThat(e, is(notNullValue()));
            assertThat(e, instanceOf(EasyMVCException.class));
            assertThat(e.getMessage(), is("java.lang.RuntimeException: Task id #45 not found."));
        }
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_supertask() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "2", "--supertaskid=1");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_update_supertask__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
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

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");
        ITable actualProperty = databaseDataSet.getTable("property");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_update_task_with_new_tags_and_properties__expecteddata.xml"));
        ITable expectedTaskTag = expectedDataSet.getTable("tasktag");
        ITable expectedProperty = expectedDataSet.getTable("property");

        Assertion.assertEquals(expectedTaskTag, actualTaskTag);
        Assertion.assertEquals(expectedProperty, actualProperty);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_update_task_and_existing_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--tags=quick,note:New note on task #3");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");
        ITable actualProperty = databaseDataSet.getTable("property");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_update_task_and_existing_properties__expecteddata.xml"));
        ITable expectedTaskTag = expectedDataSet.getTable("tasktag");
        ITable expectedProperty = expectedDataSet.getTable("property");

        Assertion.assertEquals(expectedTaskTag, actualTaskTag);
        Assertion.assertEquals(expectedProperty, actualProperty);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_remove_tags_from_task() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--removetags=important,note");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");
        ITable actualProperty = databaseDataSet.getTable("property");

        assertThat(actualTaskTag.getRowCount(), is(0));
        assertThat(actualProperty.getRowCount(), is(0));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_remove_just_one_property_from_tag() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "up", "3", "--removetags=note[creation]");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualProperty = databaseDataSet.getTable("property");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskUpTests__should_remove_just_one_property_from_tag__expecteddata.xml"));
        ITable expectedProperty = expectedDataSet.getTable("property");

        Assertion.assertEquals(expectedProperty, actualProperty);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskUpTests__should_update_task_name.xml")
    public void should_remove_remove_all_attributes_but_tag() throws EasyMVCException, SQLException, DatabaseUnitException {
        controller.run("task", "up", "3", "--removetags=note[*]");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualProperty = databaseDataSet.getTable("property");

        assertThat(actualProperty.getRowCount(), is(0));
    }
}