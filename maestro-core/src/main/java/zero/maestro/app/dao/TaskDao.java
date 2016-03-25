package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Task;

import com.j256.ormlite.support.ConnectionSource;

public class TaskDao extends AbstractDao<Task> {

    public TaskDao(ConnectionSource connection, Class<Task> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static TaskDao getInstance(ConnectionSource connection) throws SQLException {
        return (TaskDao) AbstractDao.getInstance(connection, Task.class);
    }

}
