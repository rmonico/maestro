package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

public class AttributeDao extends AbstractDao<Attribute> {

    public AttributeDao(ConnectionSource connection, Class<Attribute> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static AttributeDao getInstance(ConnectionSource connection) throws SQLException {
        return (AttributeDao) AbstractDao.getInstance(connection, Attribute.class);
    }

    public Attribute getAttributeByName(Tag tag, String attributeName) throws SQLException {
        Where<Attribute, Integer> where = queryBuilder().where();
        where.eq(Attribute.TAG_FIELD_NAME, tag.getId());
        where.and().eq(Attribute.NAME_FIELD_NAME, attributeName);

        PreparedQuery<Attribute> preparedQuery = where.prepare();

        return queryForFirst(preparedQuery);
    }

}
