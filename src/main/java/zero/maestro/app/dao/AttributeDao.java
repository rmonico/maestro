package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Attribute;

import com.j256.ormlite.support.ConnectionSource;

public class AttributeDao extends AbstractDao<Attribute> {

    public AttributeDao(ConnectionSource connection, Class<Attribute> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static AttributeDao getInstance(ConnectionSource connection) throws SQLException {
        return (AttributeDao) AbstractDao.getInstance(connection, Attribute.class);
    }

}
