package zero.maestro.app;

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

public class TagAssigner {

    private String[] tagData;
    private Task task;
    private TagDao tagDao;
    private TaskTagDao taskTagDao;
    private AttributeDao attributeDao;
    private PropertyDao propertyDao;

    public TagAssigner(Task task, String[] tagData) {
        this.task = task;
        this.tagData = tagData;
    }

    public void setDaos(TagDao tagDao, TaskTagDao taskTagDao, AttributeDao attributeDao, PropertyDao propertyDao) {
        this.tagDao = tagDao;
        this.taskTagDao = taskTagDao;
        this.attributeDao = attributeDao;
        this.propertyDao = propertyDao;
    }

    public void assignTagsToTask() throws SQLException, EasyMVCException {
        if (tagData == null)
            return;

        for (String tagData : tagData) {
            TagListArgumentParser parser = new TagListArgumentParser();
            parser.setDefaultAttributeName("default");

            parser.parse(tagData);

            String tagName = parser.getTagName();

            Tag tag = tagDao.getTagByName(tagName);

            if (tag == null)
                throw new EasyMVCException(String.format("Unknown tag: \"%s\".", tagName));

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
}
