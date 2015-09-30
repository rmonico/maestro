package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Property;

import com.j256.ormlite.support.ConnectionSource;

public class PropertyDao extends AbstractDao<Property> {

    public PropertyDao(ConnectionSource connection, Class<Property> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static PropertyDao getInstance(ConnectionSource connection) throws SQLException {
        return (PropertyDao) AbstractDao.getInstance(connection, Property.class);
    }

}
