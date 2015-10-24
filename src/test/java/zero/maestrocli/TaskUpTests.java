package zero.maestrocli;

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
}
