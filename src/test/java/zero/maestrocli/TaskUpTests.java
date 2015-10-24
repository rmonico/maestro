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
            assertThat(e, instanceOf(RuntimeException.class));
            assertThat(e.getMessage(), is("Supertask id #45 not found."));
        }
    }

}
