package zero.maestro.app.dao;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Attribute;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

public class AttributeDao extends AbstractDao<Attribute> {

    public AttributeDao(ConnectionSource connection, Class<Attribute> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static AttributeDao getInstance(ConnectionSource connection) throws SQLException {
        return (AttributeDao) AbstractDao.getInstance(connection, Attribute.class);
    }

    public Attribute queryForTagAndName(int tagId, String attributeName) throws SQLException {
        Where<Attribute, Integer> where = queryBuilder().where();
        where.eq(Attribute.TAG_FIELD_NAME, tagId);
        where.and().eq(Attribute.NAME_FIELD_NAME, attributeName);

        PreparedQuery<Attribute> preparedQuery = where.prepare();

        return queryForFirst(preparedQuery);
    }

    public List<Attribute> queryForTag(int tagId) throws SQLException {
        QueryBuilder<Attribute, Integer> builder = queryBuilder();

        Where<Attribute, Integer> where = builder.where();
        where.eq(Attribute.TAG_FIELD_NAME, tagId);

        PreparedQuery<Attribute> query = builder.prepare();

        return query(query);
    }

    public void deleteForTag(int tagId) throws SQLException {
        DeleteBuilder<Attribute, Integer> builder = deleteBuilder();

        Where<Attribute, Integer> where = builder.where();
        where.eq(Attribute.TAG_FIELD_NAME, tagId);

        PreparedDelete<Attribute> query = builder.prepare();

        delete(query);
    }
}
