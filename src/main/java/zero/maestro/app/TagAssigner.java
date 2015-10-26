package zero.maestro.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.PropertyDao;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.support.ConnectionSource;

public class TagAssigner {

    private static final String ALL_PROPERTIES_NAME = "*";
    private Task task;
    private TagDao tagDao;
    private TaskTagDao taskTagDao;
    private AttributeDao attributeDao;
    private PropertyDao propertyDao;

    public TagAssigner(Task task, ConnectionSource connection) throws SQLException {
        this.task = task;

        this.tagDao = TagDao.getInstance(connection);
        this.taskTagDao = TaskTagDao.getInstance(connection);
        this.attributeDao = AttributeDao.getInstance(connection);
        this.propertyDao = PropertyDao.getInstance(connection);
    }

    public void assignTagsToTask(String[] tagData) throws SQLException, EasyMVCException, IOException {
        if (tagData == null)
            return;

        for (String data : tagData) {
            PropertyListParser parser = new PropertyListParser();
            parser.setDefaultAttributeName("default");

            parser.parse(data);

            String tagName = parser.getTagName();

            Tag tag = getTag(tagName);

            TaskTag taskTag = taskTagDao.queryForTaskAndTagId(task.getId(), tag.getId());

            if (taskTag == null)
                taskTag = new TaskTag();

            taskTag.setTag(tag);
            taskTag.setTask(task);

            taskTagDao.createOrUpdate(taskTag);

            List<ArgumentAttribute> attributes = parser.getAttributes();

            for (ArgumentAttribute argAttribute : attributes) {
                String attributeName = argAttribute.getName();

                Attribute attribute = attributeDao.getAttributeByName(tag, attributeName);

                if (attribute == null)
                    throw new EasyMVCException(String.format("Unknown attribute: \"%s\" on tag \"%s\".", attributeName, tagName));

                Property property = propertyDao.queryForAttributeAndTaskTagId(attribute.getId(), taskTag.getId());

                if (property == null)
                    property = new Property();

                property.setAttribute(attribute);
                property.setTaskTag(taskTag);

                property.setValue(argAttribute.getValue());

                propertyDao.createOrUpdate(property);
            }
        }
    }

    private Tag getTag(String tagName) throws SQLException, EasyMVCException {
        Tag tag = tagDao.getTagByName(tagName);

        if (tag == null)
            throw new EasyMVCException(String.format("Unknown tag: \"%s\".", tagName));

        return tag;
    }

    public void removeTags(String[] tagsToRemove) throws SQLException, EasyMVCException {
        if (tagsToRemove == null)
            return;

        for (String data : tagsToRemove) {
            AttributeListParser parser = new AttributeListParser();

            parser.parse(data);

            String tagName = parser.getTagName();

            Tag tag = getTag(tagName);

            TaskTag taskTag = taskTagDao.queryForTaskAndTagId(task.getId(), tag.getId());

            if (taskTag == null)
                throw new EasyMVCException(String.format("Tag \"%s\" not found on task \"%s\".", tagName, task.getName()));

            List<String> attributes = parser.getAttributes();

            if (attributes.isEmpty()) {
                propertyDao.deletePropertiesForTaskTagId(taskTag.getId());

                taskTagDao.delete(taskTag);
            } else if (shouldRemoveAllPropertiesFromTaskTag(attributes)) {
                propertyDao.deletePropertiesForTaskTagId(taskTag.getId());
            } else {
                for (String attributeName : attributes) {
                    Attribute attribute = attributeDao.getAttributeByName(tag, attributeName);

                    if (attribute == null)
                        throw new EasyMVCException(String.format("Unknown attribute: \"%s\" on tag \"%s\".", attributeName, tagName));

                    Property property = propertyDao.queryForAttributeAndTaskTagId(attribute.getId(), taskTag.getId());

                    if (property == null)
                        throw new EasyMVCException(String.format("Unknown property: \"%s\" on tag \"%s\" of task #%d.", attributeName, tagName, task.getId()));

                    propertyDao.delete(property);
                }
            }
        }
    }

    private boolean shouldRemoveAllPropertiesFromTaskTag(List<String> attributes) {
        if (attributes.size() > 0)
            if (ALL_PROPERTIES_NAME.equals(attributes.get(0)))
                return true;

        return false;
    }
}
