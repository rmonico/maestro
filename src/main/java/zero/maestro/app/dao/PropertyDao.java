package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Property;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

public class PropertyDao extends AbstractDao<Property> {

    public PropertyDao(ConnectionSource connection, Class<Property> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static PropertyDao getInstance(ConnectionSource connection) throws SQLException {
        return (PropertyDao) AbstractDao.getInstance(connection, Property.class);
    }

    public Property queryForAttributeAndTaskTagId(int attributeId, int taskTagId) throws SQLException {
        Where<Property, Integer> where = queryBuilder().where();
        where.eq(Property.ATTRIBUTE_FIELD_NAME, attributeId);
        where.and().eq(Property.TASKTAG_FIELD_NAME, taskTagId);

        PreparedQuery<Property> query = where.prepare();

        return queryForFirst(query);
    }

}
