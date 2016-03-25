package zero.maestrocli;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.core.Is.is;

import java.net.MalformedURLException;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
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

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(1));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"no_attribute_tag\" removed."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_with_its_attributes() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_attributes");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(3));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_attributes\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Attribute \"attr1\" (type TEXT) removed."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Attribute \"another_attribute\" (type INTEGER) removed."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_and_related_tasktags() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_tasks");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(3));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_tasks\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Task \"A task\" unmarked."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Task \"Another task\" unmarked."));
    }

    @Test
    @DBUnitDatasetFileNames("dbunit/TagRemoveTests__base_data.xml")
    public void should_remove_tag_its_attributes_related_tasktags_and_properties() throws EasyMVCException, SQLException, DatabaseUnitException, MalformedURLException {
        controller.run("tag", "rm", "tag_with_tasks_attributes_and_properties");

        assertThat("Line count", sysoutWrapper.capturedLines.size(), greaterThanOrEqualTo(5));
        assertThat("Line #0", sysoutWrapper.capturedLines.get(0), is("Tag \"tag_with_tasks_attributes_and_properties\" removed."));
        assertThat("Line #1", sysoutWrapper.capturedLines.get(1), is("Task \"A task\" unmarked."));
        assertThat("Line #2", sysoutWrapper.capturedLines.get(2), is("Task \"Another task\" unmarked."));
        assertThat("Line #3", sysoutWrapper.capturedLines.get(3), is("Attribute \"default\" (type TEXT) removed."));
        assertThat("Line #4", sysoutWrapper.capturedLines.get(4), is("Attribute \"creation\" (type TEXT) removed."));
    }

}
