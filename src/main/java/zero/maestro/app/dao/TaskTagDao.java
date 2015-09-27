package zero.maestro.app.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

public class TaskTagDao extends AbstractDao<TaskTag> {

    public TaskTagDao(ConnectionSource connection, Class<TaskTag> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static TaskTagDao getInstance(ConnectionSource connection) throws SQLException {
        return (TaskTagDao) AbstractDao.getInstance(connection, TaskTag.class);
    }

    public List<Tag> getTags(TagDao tagDao, int taskId) throws SQLException {
        QueryBuilder<TaskTag, Integer> builder = queryBuilder();

        QueryBuilder<Tag, Integer> tagBuilder = tagDao.queryBuilder();

        tagBuilder.orderBy(Tag.NAME_FIELD_NAME, true);

        builder.join(tagBuilder);

        builder.where().eq(TaskTag.TASK_FIELD_NAME, taskId);

        PreparedQuery<TaskTag> query = builder.prepare();

        List<TaskTag> list = query(query);

        List<Tag> tagList = new LinkedList<>();

        for (TaskTag taskTag : list) {
            Tag tag = taskTag.getTag();

            tagList.add(tag);
        }

        return tagList;
    }

}
