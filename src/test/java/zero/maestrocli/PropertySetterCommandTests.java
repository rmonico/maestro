package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Property;
import zero.utils.test.DBUnitDatasetFileNames;

public class PropertySetterCommandTests extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/PropertySetterCommand__should_create_a_property_for_existing_tasktag.xml")
    public void should_create_a_property_for_existing_tasktag() throws EasyMVCException {
        List<Object> beans = controller.run("prop", "set", "1", "note", "default", "Value of default property of tag note on Task #1");

        EasyMVCAssert.assertBeanList(beans, 1);

        Property property = EasyMVCAssert.assertAndGetBean(beans, 0, Property.class);

        Assert.assertProperty("default", 1, "Value of default property of tag note on Task #1", property);
    }

    @Test(expected = EasyMVCException.class)
    @DBUnitDatasetFileNames("dbunit/PropertySetterCommand__should_throw_a_exception_when_try_to_set_to_a_non_existing_task_tag_relationship.xml")
    public void should_throw_a_exception_when_try_to_set_to_a_non_existing_task_tag_relationship() throws EasyMVCException {
        try {
            controller.run("prop", "set", "1", "note", "default", "Value of default property of tag note on Task #1");
        } catch (EasyMVCException e) {
            assertEquals("Exception message", "zero.easymvc.EasyMVCException: Task #1 is not marked with tag \"note\".", e.getMessage());

            throw e;
        }
    }

    @Test(expected = EasyMVCException.class)
    @DBUnitDatasetFileNames("dbunit/PropertySetterCommand__should_throw_exception_when_try_to_set_a_to_a_non_existing_attribute.xml")
    public void should_throw_exception_when_try_to_set_a_to_a_non_existing_attribute() throws EasyMVCException {
        try {
            controller.run("prop", "set", "1", "note", "default", "Value of default property of tag note on Task #1");
        } catch (EasyMVCException e) {
            assertEquals("Exception message", "zero.easymvc.EasyMVCException: Tag \"note\" doesn't have attribute \"default\".", e.getMessage());

            throw e;
        }
    }
}
