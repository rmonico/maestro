package zero.maestro.app.dao;

import java.sql.SQLException;

import zero.easymvc.ormlite.dao.AbstractDao;
import zero.maestro.model.Tag;

import com.j256.ormlite.support.ConnectionSource;

public class TagDao extends AbstractDao<Tag> {

    public TagDao(ConnectionSource connection, Class<Tag> dataClass) throws SQLException {
        super(connection, dataClass);
    }

    public static TagDao getInstance(ConnectionSource connection) throws SQLException {
        return (TagDao) AbstractDao.getInstance(connection, Tag.class);
    }

}
