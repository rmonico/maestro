package zero.maestro.app;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

public class TagListCommand {

    @Dependency
    private TagDao dao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Bean
    private List<Tag> tags;

    @Bean
    private Map<Tag, Integer> taskCount;

    @CommandHandler(path = { "tag", "ls" })
    public void execute() throws SQLException {
        tags = dao.queryForAll();

        taskCount = new HashMap<>();

        for (Tag tag : tags) {
            List<TaskTag> tasks = taskTagDao.queryForTag(tag.getId());

            taskCount.put(tag, tasks.size());
        }
    }

}
