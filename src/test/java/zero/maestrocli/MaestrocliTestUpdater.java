package zero.maestrocli;

import zero.easymvc.ormlite.AbstractDatabaseVersion;
import zero.easymvc.ormlite.DatabaseVersion;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MaestrocliTestUpdater extends AbstractDatabaseVersion {

    public MaestrocliTestUpdater(ConnectionSource connection, DatabaseVersion previousVersion) {
        super(connection, previousVersion);
    }

    @Override
    public void update() throws Exception {
        TableUtils.dropTable(connection, Task.class, true);
        TableUtils.dropTable(connection, Tag.class, true);

        super.update();
    }

    @Override
    public int getCurrentVersion() {
        return 0;
    }

}
