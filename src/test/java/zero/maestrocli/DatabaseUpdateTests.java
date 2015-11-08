package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.File;
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

public class DatabaseUpdateTests extends MaestrocliTest {

    private SysoutWrapper sysoutWrapper;

    @Before
    public void setup() {
        sysoutWrapper = new SysoutWrapper();
        System.setOut(sysoutWrapper);
    }

    @Test
    public void should_create_initial_database() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("--check-and-update-database");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualMetainf = databaseDataSet.getTable("metainf");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/DatabaseUpdateTests__should_create_initial_database__expecteddata.xml"));
        ITable expectedMetainf = expectedDataSet.getTable("metainf");

        Assertion.assertEquals(expectedMetainf, actualMetainf);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), is(7));

        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Checking database structure for updates..."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Database not found! Creating it!"));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is(""));
        assertThat("Line #3", sysoutWrapper.capturedLines.get(3), is("Database version is 0"));
        assertThat("Line #4", sysoutWrapper.capturedLines.get(4), is("Application version is 0.1"));
        assertThat("Line #5", sysoutWrapper.capturedLines.get(5), is(""));
        assertThat("Line #6", sysoutWrapper.capturedLines.get(6), is("Update done. Everything is OK."));
    }
}
