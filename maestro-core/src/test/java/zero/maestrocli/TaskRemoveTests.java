package zero.maestrocli;

import static org.junit.Assert.assertEquals;

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

public class TaskRemoveTests extends MaestroTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskRemoveTests__should_remove_a_task.xml")
    public void should_remove_a_task() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "rm", "1");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskRemoveTests__should_remove_a_task__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskRemoveTests__should_remove_task_and_its_tags.xml")
    public void should_remove_task_and_its_tags() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "rm", "1");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskRemoveTests__should_remove_task_and_its_tags__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
        assertEquals("TaskTag row count", 0, actualTaskTag.getRowCount());
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskRemoveTests__should_remove_task_and_its_tags_and_properties.xml")
    public void should_remove_task_and_its_tags_and_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "rm", "1");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");
        ITable actualProperty = databaseDataSet.getTable("property");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskRemoveTests__should_remove_task_and_its_tags_and_properties__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");
        ITable expectedTaskTag = expectedDataSet.getTable("tasktag");
        ITable expectedProperty = expectedDataSet.getTable("property");

        Assertion.assertEquals(expectedTask, actualTask);
        Assertion.assertEquals(expectedTaskTag, actualTaskTag);
        Assertion.assertEquals(expectedProperty, actualProperty);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskRemoveTests__should_remove_task_and_its_subtasks.xml")
    public void should_remove_task_and_its_subtasks() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "rm", "1");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTask = databaseDataSet.getTable("task");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskRemoveTests__should_remove_task_and_its_subtasks__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
    }
}
