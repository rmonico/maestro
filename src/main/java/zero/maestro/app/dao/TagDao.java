package zero.maestro.app.dao;

import java.sql.SQLException;
import java.util.List;

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

    public Tag queryForName(String tagName) throws SQLException {
        List<Tag> tags = queryForEq(Tag.NAME_FIELD_NAME, tagName);

        if (tags.isEmpty())
            return null;
        else
            return tags.get(0);
    }

}
