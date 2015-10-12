package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.PropertyDao;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

public class TaskCreateCommand {

    @Dependency
    private TaskDao dao;

    @Dependency
    private TagDao tagDao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Dependency
    private AttributeDao attributeDao;

    @Dependency
    private PropertyDao propertyDao;

    @ArgumentsBean
    private TaskCreateArguments args;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "add" })
    public void execute() throws SQLException, EasyMVCException {
        task = new Task();

        task.setName(args.getTaskName());

        Task superTask = getSuperTask();

        if (superTask != null)
            task.setSuperTask(superTask);

        dao.create(task);

        assignTagsToTask();
    }

    private Task getSuperTask() throws SQLException {
        Integer superTaskID = args.getSuperTaskID();

        if (superTaskID == null)
            return null;

        Task superTask = dao.queryForId(superTaskID);

        return superTask;
    }

    private void assignTagsToTask() throws SQLException, EasyMVCException {
        if (args.getTags() == null)
            return;

        for (String tagData : args.getTags()) {
            TagListArgumentParser parser = new TagListArgumentParser();
            parser.setDefaultAttributeName("default");

            parser.parse(tagData);

            String tagName = parser.getTagName();

            Tag tag = tagDao.getTagByName(tagName);

            if (tag == null)
                throw new EasyMVCException(String.format("Unknown tag: \"%s\".", tagName));

            TaskTag taskTag = new TaskTag();

            taskTag.setTag(tag);
            taskTag.setTask(task);

            taskTagDao.create(taskTag);

            List<ArgumentAttribute> attributes = parser.getAttributes();

            for (ArgumentAttribute argAttribute : attributes) {
                String attributeName = argAttribute.getName();

                Attribute attribute = attributeDao.getAttributeByName(tag, attributeName);

                if (attribute == null)
                    throw new EasyMVCException(String.format("Unknown attribute: \"%s\" on tag \"%s\".", attributeName, tagName));

                Property property = new Property();

                property.setAttribute(attribute);
                property.setTaskTag(taskTag);

                property.setValue(argAttribute.getValue());

                propertyDao.create(property);
            }
        }
    }

}
