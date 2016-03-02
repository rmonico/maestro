package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
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
import org.junit.Before;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
import zero.utils.sysoutwrapper.SysoutWrapper;
import zero.utils.test.DBUnitDatasetFileNames;

public class TagRemoveTests extends MaestrocliTest {

    private SysoutWrapper sysoutWrapper;

    @Before
    public void setup() {
        sysoutWrapper = new SysoutWrapper();
        System.setOut(sysoutWrapper);
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_a_single_tag() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "no_attribute_tag");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTag = databaseDataSet.getTable("tag");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TagRemoveTests__should_remove_a_single_tag__expecteddata.xml"));
        ITable expectedTag = expectedDataSet.getTable("tag");

        Assertion.assertEquals(expectedTag, actualTag);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(1));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"no_attribute_tag\" removed."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_with_its_attributes() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_attributes");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTag = databaseDataSet.getTable("tag");
        ITable actualAttribute = databaseDataSet.getTable("attribute");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TagRemoveTests__should_remove_tag_with_its_attributes__expecteddata.xml"));
        ITable expectedTag = expectedDataSet.getTable("tag");
        ITable expectedAttribute = expectedDataSet.getTable("attribute");

        Assertion.assertEquals(expectedTag, actualTag);
        Assertion.assertEquals(expectedAttribute, actualAttribute);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(3));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_attributes\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Attribute \"attr1\" (type TEXT) removed."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Attribute \"another_attribute\" (type INTEGER) removed."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_and_related_tasktags() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_tasks");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTag = databaseDataSet.getTable("tag");
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TagRemoveTests__should_remove_tag_and_related_tasktags__expecteddata.xml"));
        ITable expectedTag = expectedDataSet.getTable("tag");
        ITable expectedTaskTag = expectedDataSet.getTable("tasktag");

        Assertion.assertEquals(expectedTag, actualTag);
        Assertion.assertEquals(expectedTaskTag, actualTaskTag);

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(3));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_tasks\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Task \"A task\" unmarked."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Task \"Another task\" unmarked."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_its_attributes_related_tasktags_and_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_tasks_attributes_and_properties");

        IDataSet databaseDataSet = getDBUnitDataset();
        ITable actualTag = databaseDataSet.getTable("tag");
        ITable actualTaskTag = databaseDataSet.getTable("tasktag");
        ITable actualAttribute = databaseDataSet.getTable("attribute");
        ITable actualProperty = databaseDataSet.getTable("property");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TagRemoveTests__should_remove_tag_its_attributes_related_tasktags_and_properties__expecteddata.xml"));
        ITable expectedTag = expectedDataSet.getTable("tag");
        ITable expectedTaskTag = expectedDataSet.getTable("tasktag");
        ITable expectedAttribute = expectedDataSet.getTable("attribute");

        Assertion.assertEquals(expectedTag, actualTag);
        Assertion.assertEquals(expectedTaskTag, actualTaskTag);
        Assertion.assertEquals(expectedAttribute, actualAttribute);
        assertThat("Property table", actualProperty.getRowCount(), is(0));

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(5));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_tasks_attributes_and_properties\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Task \"A task\" unmarked."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Task \"Another task\" unmarked."));
        assertThat("Line #3", sysoutWrapper.capturedLines.get(3), is("Attribute \"default\" (type TEXT) removed."));
        assertThat("Line #4", sysoutWrapper.capturedLines.get(4), is("Attribute \"creation\" (type TEXT) removed."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_throw_exception_when_try_to_remove_unexisting_tag() {
        try {
            controller.run("tag", "rm", "unexisting_tag");

            fail("Exception not throw!");
        } catch (EasyMVCException e) {
            Throwable cause = e.getCause();

            assertThat("Cause not null", cause, is(notNullValue()));
            assertThat("Exception class", cause, instanceOf(EasyMVCException.class));
            assertThat("Message", cause.getMessage(), is("Unknown tag: \"unexisting_tag\"."));
        }
    }
}
