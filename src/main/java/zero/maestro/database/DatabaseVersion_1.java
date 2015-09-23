package zero.maestro.database;

import zero.easymvc.ormlite.AbstractDatabaseVersion;
import zero.easymvc.ormlite.MetaInfUpdater;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseVersion_1 extends AbstractDatabaseVersion {

    private static final int THIS_VERSION = 1;

    public DatabaseVersion_1(ConnectionSource connection) {
        super(connection, new MetaInfUpdater(connection));
    }

    @Override
    public void update() throws Exception {
        if (THIS_VERSION > getOldVersion()) {
            TableUtils.createTableIfNotExists(connection, Task.class);
            TableUtils.createTableIfNotExists(connection, Tag.class);
            TableUtils.createTableIfNotExists(connection, Attribute.class);
        }
    }

    @Override
    public int getCurrentVersion() {
        return THIS_VERSION;
    }

}
