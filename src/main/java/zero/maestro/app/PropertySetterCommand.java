package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.EasyMVCException;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.TaskTag;

public class PropertySetterCommand {

    @ArgumentsBean
    private PropertySetterArguments args;

    @Bean
    private Property property;

    @CommandHandler(path = { "prop", "set" })
    public void execute() throws SQLException, EasyMVCException {
        property = new Property();

        Attribute attribute = new Attribute();

        attribute.setName("default");
        property.setAttribute(attribute);

        TaskTag taskTag = new TaskTag();
        taskTag.setId(1);
        property.setTaskTag(taskTag);

        property.setValue("Value of default property of tag note on Task #1");
    }
}
