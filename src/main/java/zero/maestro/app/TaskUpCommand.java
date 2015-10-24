package zero.maestro.app;

import java.sql.SQLException;

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
import zero.maestro.model.Task;

public class TaskUpCommand {

    @ArgumentsBean
    private TaskUpArguments args;

    @Bean
    private Task task;

    @Dependency
    private TaskDao dao;

    @Dependency
    private TagDao tagDao;

    @Dependency
    private TaskTagDao tasktagDao;

    @Dependency
    private AttributeDao attributeDao;

    @Dependency
    private PropertyDao propertyDao;

    @CommandHandler(path = { "task", "up" })
    public void execute() throws SQLException, EasyMVCException {
        Task task = dao.queryForId(args.getTaskId());

        if (task == null) {
            String message = String.format("Task id #%d not found.", args.getTaskId());
            throw new RuntimeException(message);
        }

        if (args.getName() != null) {
            task.setName(args.getName());
        }

        Integer supertaskID = args.getSupertaskID();

        if (supertaskID != null) {
            Task superTask = dao.queryForId(supertaskID);

            if (superTask == null) {
                String message = String.format("Supertask id #%d not found.", supertaskID);
                throw new RuntimeException(message);
            }

            task.setSuperTask(superTask);
        }

        // TODO Check if task was changed
        dao.update(task);

        TagAssigner assigner = new TagAssigner(task, args.getTags());

        assigner.setDaos(tagDao, tasktagDao, attributeDao, propertyDao);

        assigner.assignTagsToTask();
    }
}
