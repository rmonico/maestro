package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Property;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

public class PropertyDao extends AbstractDao<Property> {

    public PropertyDao(ConnectionSource connection, Class<Property> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static PropertyDao getInstance(ConnectionSource connection) throws SQLException {
        return (PropertyDao) AbstractDao.getInstance(connection, Property.class);
    }

    public Property queryForAttributeAndTaskTag(int attributeId, int taskTagId) throws SQLException {
        Where<Property, Integer> where = queryBuilder().where();
        where.eq(Property.ATTRIBUTE_FIELD_NAME, attributeId);
        where.and().eq(Property.TASKTAG_FIELD_NAME, taskTagId);

        PreparedQuery<Property> query = where.prepare();

        return queryForFirst(query);
    }

    public void deletePropertiesForTaskTag(int taskTagId) throws SQLException {
        DeleteBuilder<Property, Integer> builder = deleteBuilder();

        Where<Property, Integer> where = builder.where();
        where.eq(Property.TASKTAG_FIELD_NAME, taskTagId);

        PreparedDelete<Property> query = builder.prepare();

        delete(query);
    }

    public void deleteForTag(int tagId) throws SQLException {
        DeleteBuilder<Property, Integer> builder = deleteBuilder();

        makeQueryForTag(tagId, builder);

        PreparedDelete<Property> query = builder.prepare();

        delete(query);
    }

    private void makeQueryForTag(int tagId, StatementBuilder<Property, Integer> builder) throws SQLException {
        QueryBuilder<TaskTag, Integer> taskTagBuilder = TaskTagDao.getInstance(getConnectionSource()).queryBuilder();

        taskTagBuilder.selectColumns(TaskTag.ID_FIELD_NAME);

        taskTagBuilder.where().eq(TaskTag.TAG_FIELD_NAME, tagId);

        builder.where().in(Property.TASKTAG_FIELD_NAME, taskTagBuilder);
    }

}
