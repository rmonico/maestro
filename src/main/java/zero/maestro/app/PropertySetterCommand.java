package zero.maestro.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.PropertyDao;
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
    private PropertyDao dao;

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

        TaskTag taskTag = taskTagDao.queryForTaskAndTagId(args.getTaskId(), tag.getId());

        if (taskTag == null)
            throw new EasyMVCException(String.format("Task #%d is not marked with tag \"%s\".", args.getTaskId(), args.getTagName()));

        property.setTaskTag(taskTag);

        Attribute attribute = attributeDao.getForTagAndName(tag, args.getAttributeName());

        if (attribute == null)
            throw new EasyMVCException(String.format("Tag \"%s\" doesn't have attribute \"%s\".", args.getTagName(), args.getAttributeName()));

        property.setAttribute(attribute);

        try {
            property.setValue(getAttributeValue());
        } catch (IOException e) {
            throw new EasyMVCException(e);
        }

        dao.create(property);
    }

    private String getAttributeValue() throws IOException {
        String attributeValue = args.getAttributeValue();

        if (attributeValue.startsWith("@")) {
            String valueFileName = attributeValue.substring(1);

            File file = new File(valueFileName);

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));

            StringBuilder value = new StringBuilder();

            try {
                String str;

                while ((str = reader.readLine()) != null) {
                    value.append(str);
                    value.append("\n");
                }

                value.deleteCharAt(value.length() - 1);
            } finally {
                reader.close();
            }

            return value.toString();
        }

        return attributeValue;
    }
}
