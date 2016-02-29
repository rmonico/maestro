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
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

public class TagRemoveCommand {

    @ArgumentsBean
    private TagRemoveArguments args;

    @Dependency
    private TagDao dao;

    @Dependency
    private AttributeDao attributeDao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Dependency
    private PropertyDao propertyDao;

    @Bean
    private Tag removedTag;

    @Bean
    private List<Attribute> attributes;

    @Bean
    private List<TaskTag> taskTags;

    @CommandHandler(path = { "tag", "rm" })
    public void execute() throws SQLException, EasyMVCException {
        removedTag = dao.queryForName(args.getTagName());

        if (removedTag == null) {
            String message = String.format("Unknown tag: \"%s\".", args.getTagName());
            throw new EasyMVCException(message);
        }

        int tagId = removedTag.getId();

        attributes = attributeDao.queryForTag(tagId);

        attributeDao.deleteForTag(tagId);

        propertyDao.deleteForTag(tagId);

        taskTags = taskTagDao.queryForTag(tagId);

        taskTagDao.deleteForTag(tagId);

        dao.delete(removedTag);
    }
}
