package zero.maestro.app.dao;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
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

    public TaskTag queryForTaskAndTag(int taskId, int tagId) throws SQLException {
        Where<TaskTag, Integer> where = queryBuilder().where();
        where.eq(TaskTag.TAG_FIELD_NAME, tagId);
        where.and().eq(TaskTag.TASK_FIELD_NAME, taskId);

        PreparedQuery<TaskTag> query = where.prepare();

        return queryForFirst(query);
    }

    public List<TaskTag> queryForTag(int tagId) throws SQLException {
        Where<TaskTag, Integer> where = queryBuilder().where();
        where.eq(TaskTag.TAG_FIELD_NAME, tagId);

        PreparedQuery<TaskTag> query = where.prepare();

        return query(query);
    }

    public List<TaskTag> queryForTask(int taskId) throws SQLException {
        Where<TaskTag, Integer> where = queryBuilder().where();
        where.eq(TaskTag.TASK_FIELD_NAME, taskId);

        PreparedQuery<TaskTag> query = where.prepare();

        return query(query);
    }

    public void deleteForTag(int tagId) throws SQLException {
        DeleteBuilder<TaskTag, Integer> builder = deleteBuilder();
        Where<TaskTag, Integer> where = builder.where();
        where.eq(TaskTag.TAG_FIELD_NAME, tagId);

        PreparedDelete<TaskTag> query = builder.prepare();

        delete(query);
    }

}
