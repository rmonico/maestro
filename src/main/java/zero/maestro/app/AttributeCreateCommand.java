package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.AttributeType;
import zero.maestro.model.Tag;

public class AttributeCreateCommand {

    @ArgumentsBean
    private AttributeCreateArguments arguments;

    @Dependency
    private TagDao tagDao;

    @Dependency
    private AttributeDao dao;

    @Bean
    private Tag changedTag;

    @CommandHandler(path = { "attr", "add" })
    public void execute() throws SQLException {
        Attribute attribute = new Attribute();

        attribute.setName(arguments.getAttributeName());

        changedTag = getTag();

        attribute.setTag(changedTag);

        AttributeType attributeType = getAttributeType();

        attribute.setType(attributeType);

        dao.create(attribute);
    }

    private Tag getTag() throws SQLException {
        String tagName = arguments.getTagName();

        Tag tag = tagDao.queryForName(tagName);

        if (tag == null)
            throw new RuntimeException(String.format("Tag unknown: \"%s\"", tagName));

        return tag;
    }

    private AttributeType getAttributeType() {
        String attributeTypeName = arguments.getAttributeType();

        AttributeType attributeType = AttributeType.getAttributeTypeByName(attributeTypeName);

        if (attributeType == null)
            throw new RuntimeException(String.format("Attribute type not known: \"%s\"", attributeTypeName));

        return attributeType;
    }

}
