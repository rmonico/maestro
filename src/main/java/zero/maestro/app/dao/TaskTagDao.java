package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.support.ConnectionSource;

public class TaskTagDao extends AbstractDao<TaskTag> {

    public TaskTagDao(ConnectionSource connection, Class<TaskTag> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static TaskTagDao getInstance(ConnectionSource connection) throws SQLException {
        return (TaskTagDao) AbstractDao.getInstance(connection, TaskTag.class);
    }

}
