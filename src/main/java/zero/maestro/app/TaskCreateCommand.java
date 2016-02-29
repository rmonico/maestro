package zero.maestro.app;

import java.io.IOException;
import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.model.Task;

import com.j256.ormlite.support.ConnectionSource;

public class TaskCreateCommand {

    @Dependency
    private TaskDao dao;

    @Dependency
    private ConnectionSource connection;

    @ArgumentsBean
    private TaskCreateArguments args;

    @Bean
    private Task task;

    @CommandHandler(path = { "task", "add" })
    public void execute() throws SQLException, EasyMVCException, IOException {
        task = new Task();

        task.setName(args.getTaskName());

        Task superTask = getSuperTask();

        if (superTask != null)
            task.setSuperTask(superTask);

        dao.create(task);

        TagAssigner assigner = new TagAssigner(task, connection);

        assigner.assignTagsToTask(args.getTags());
    }

    private Task getSuperTask() throws SQLException {
        Integer superTaskID = args.getSuperTaskID();

        if (superTaskID == null)
            return null;

        Task superTask = dao.queryForId(superTaskID);

        return superTask;
    }

}
