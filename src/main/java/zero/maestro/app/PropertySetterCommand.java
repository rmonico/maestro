package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

public class PropertySetterCommand {

    @ArgumentsBean
    private PropertySetterArguments args;

    @Dependency
    private AttributeDao attributeDao;

    @Dependency
    private TagDao tagDao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Bean
    private Property property;

    @CommandHandler(path = { "prop", "set" })
    public void execute() throws SQLException, EasyMVCException {
        property = new Property();

        Tag tag = tagDao.getTagByName(args.getTagName());

        Attribute attribute = attributeDao.getForTagAndName(tag, args.getAttributeName());

        property.setAttribute(attribute);

        TaskTag taskTag = taskTagDao.queryForTaskAndTagId(args.getTaskId(), tag.getId());
        property.setTaskTag(taskTag);

        property.setValue(args.getAttributeValue());
    }

}
