package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

public class TaskTagDao extends AbstractDao<TaskTag> {

    public TaskTagDao(ConnectionSource connection, Class<TaskTag> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static TaskTagDao getInstance(ConnectionSource connection) throws SQLException {
        return (TaskTagDao) AbstractDao.getInstance(connection, TaskTag.class);
    }

    public TaskTag queryForTaskAndTagId(int taskId, int tagId) throws SQLException {
        Where<TaskTag, Integer> where = queryBuilder().where();
        where.eq(TaskTag.TAG_FIELD_NAME, tagId);
        where.and().eq(TaskTag.TASK_FIELD_NAME, taskId);

        PreparedQuery<TaskTag> query = where.prepare();

        return queryForFirst(query);
    }

}
