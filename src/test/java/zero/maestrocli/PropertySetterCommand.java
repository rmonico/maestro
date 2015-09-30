package zero.maestrocli;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Property;
import zero.utils.test.DBUnitDatasetFileNames;

public class PropertySetterCommand extends MaestrocliTest {

    @Test
    @DBUnitDatasetFileNames("dbunit/PropertySetterCommand__should_create_a_property_for_existing_tasktag.xml")
    public void should_create_a_property_for_existing_tasktag() throws EasyMVCException {
        List<Object> beans = controller.run("prop", "set", "1", "note", "default", "Value of default property of tag note on Task #1");

        EasyMVCAssert.assertBeanList(beans, 1);

        Property property = EasyMVCAssert.assertAndGetBean(beans, 0, Property.class);

        Assert.assertProperty("default", 1, "Value of default property of tag note on Task #1", property);
    }
}
