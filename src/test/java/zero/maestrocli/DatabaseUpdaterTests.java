package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.sysoutwrapper.SysoutWrapper;
import zero.utils.test.UpdateDatabaseToVersion;

public class DatabaseUpdaterTests extends MaestrocliTest {

    private SysoutWrapper sysoutWrapper;

    @Before
    public void setup() {
        sysoutWrapper = new SysoutWrapper();
        System.setOut(sysoutWrapper);
    }

    private boolean isTableExists(IDataSet dataset, String tableName) throws DataSetException {
        String[] tableNames = dataset.getTableNames();

        for (String candidateTableName : tableNames) {
            if (candidateTableName.equals(tableName))
                return true;
        }

        return false;
    }

    @Test
    @UpdateDatabaseToVersion(0)
    public void should_create_initial_database() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("--check-and-update-database");

        IDataSet dataset = getDBUnitDataset();

        assertThat("metainf table existence", isTableExists(dataset, "metainf"), is(true));

        ITable actualMetainf = dataset.getTable("metainf");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/DatabaseUpdateTests__should_create_initial_database__expecteddata.xml"));
        ITable expectedMetainf = expectedDataSet.getTable("metainf");

        Assertion.assertEquals(expectedMetainf, actualMetainf);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), is(7));

        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Checking database structure for updates..."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Database not found! Creating it!"));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is(""));
        assertThat("Line #3", sysoutWrapper.capturedLines.get(3), is("Database version is 0"));
        assertThat("Line #4", sysoutWrapper.capturedLines.get(4), is("Application version is 0.0"));
        assertThat("Line #5", sysoutWrapper.capturedLines.get(5), is(""));
        assertThat("Line #6", sysoutWrapper.capturedLines.get(6), is("Update done. Everything is OK."));
    }

    @Test
    @UpdateDatabaseToVersion(1)
    public void should_update_database_to_version_1() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("--check-and-update-database");

        IDataSet dataset = getDBUnitDataset();
        ITable actualMetainf = dataset.getTable("metainf");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/DatabaseUpdateTests__should_update_database_to_version_1__expecteddata.xml"));
        ITable expectedMetainf = expectedDataSet.getTable("metainf");

        Assertion.assertEquals(expectedMetainf, actualMetainf);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), is(7));

        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Checking database structure for updates..."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Database on version 0 found. Updating it to version 1"));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is(""));
        assertThat("Line #3", sysoutWrapper.capturedLines.get(3), is("Database version is 1"));
        assertThat("Line #4", sysoutWrapper.capturedLines.get(4), is("Application version is 0.6"));
        assertThat("Line #5", sysoutWrapper.capturedLines.get(5), is(""));
        assertThat("Line #6", sysoutWrapper.capturedLines.get(6), is("Update done. Everything is OK."));
    }
}
