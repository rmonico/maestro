package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
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

    @ArgumentsBean
    private TaskCreateArguments args;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "add" })
    public void execute() throws SQLException {
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

    private void assignTagsToTask() throws SQLException {
        if (args.getTags() == null)
            return;

        for (String tagName : args.getTags()) {
            Tag tag = tagDao.getTagByName(tagName);

            TaskTag taskTag = new TaskTag();

            taskTag.setTag(tag);
            taskTag.setTask(task);

            taskTagDao.create(taskTag);
        }
    }

}
