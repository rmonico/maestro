package zero.maestro.database;

import zero.easymvc.ormlite.MetaInfUpdater;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseVersion_1 extends MetaInfUpdater {

    public DatabaseVersion_1(ConnectionSource connection) {
        super(connection);

        setUpdaterVersion(1);

        setApplicationMajorVersion(0);
        setApplicationMinorVersion(6);
    }

    @Override
    public void update(int databaseVersion) throws Exception {
        super.update(databaseVersion);

        if (!shouldUpdate())
            return;

        TableUtils.createTableIfNotExists(connection, Task.class);
        TableUtils.createTableIfNotExists(connection, Tag.class);
        TableUtils.createTableIfNotExists(connection, Attribute.class);
        TableUtils.createTableIfNotExists(connection, TaskTag.class);
        TableUtils.createTableIfNotExists(connection, Property.class);
    }

}
