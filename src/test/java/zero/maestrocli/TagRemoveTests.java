package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
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
import org.junit.Ignore;
import org.junit.Test;

import zero.easymvc.EasyMVCException;
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
        ITable actualAttributes = databaseDataSet.getTable("attribute");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new File("dbunit/TagRemoveTests__should_remove_tag_with_its_attributes__expecteddata.xml"));
        ITable expectedTag = expectedDataSet.getTable("tag");

        Assertion.assertEquals(expectedTag, actualTag);
        assertThat("Attribute table", actualAttributes.getRowCount(), is(0));

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(1));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_attributes\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Attribute \"attr1\" (type TEXT) removed."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Attribute \"another_attribute\" (type INTEGER) removed."));
    }

    @Ignore
    @Test
    public void should_remove_tag_and_related_tasktags() {

    }

    @Ignore
    @Test
    public void should_remove_tag_its_attributes_and_related_tasktags() {

    }
}
