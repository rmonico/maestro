package zero.maestrocli;

import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.MetaInfUpdater;
import zero.utils.test.DBUnitUpdater;
import zero.utils.test.TestApplicationFactory;

import com.j256.ormlite.support.ConnectionSource;

public class MaestrocliTestApplicationFactory extends MaestrocliApplicationFactory implements TestApplicationFactory {

    private String[] datasetFileNames;
    private int updaterVersion = -1;

    public MaestrocliTestApplicationFactory() {
        super(MaestrocliApplicationFactory.BASENAME + "_test");

    }

    @Override
    public void setDatabaseFileNames(String[] datasetFileNames) {
        this.datasetFileNames = datasetFileNames;
    }

    @Override
    public void setDatabaseUpdaterVersion(int updaterVersion) {
        this.updaterVersion = updaterVersion;
    }

    @Override
    public DatabaseUpdater getDatabaseUpdater() {
        ConnectionSource connection = connectionManager.getConnection();

        return new DBUnitUpdater(connection, getUpdaterFor(connection), datasetFileNames);
    }

    private DatabaseUpdater getUpdaterFor(ConnectionSource connection) {
        switch (updaterVersion) {
        case -1:
        case 1:
            return super.getDatabaseUpdater();

        case 0:
            return new MetaInfUpdater(connection);

        default:
            return null;
        }
    }

}
