package zero.maestrocli;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.test.DBUnitDatasetFileNames;

public class TaskRemoveTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/TaskRemoveTests__should_remove_a_task.xml")
    public void should_remove_a_task() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("task", "rm", "1");

        String connectionString = connectionManager.getConnectionString();
        Connection jdbcConnection = DriverManager.getConnection(connectionString);

        DatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        IDataSet databaseDataSet = connection.createDataSet();
        ITable actualTask = databaseDataSet.getTable("task");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TaskRemoveTests__should_remove_a_task__expecteddata.xml"));
        ITable expectedTask = expectedDataSet.getTable("task");

        Assertion.assertEquals(expectedTask, actualTask);
    }
}
