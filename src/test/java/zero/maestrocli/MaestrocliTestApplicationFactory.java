package zero.maestrocli;

import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.MetaInfUpdater;
import zero.utils.test.TestApplicationFactory;

import com.j256.ormlite.support.ConnectionSource;

public class MaestrocliTestApplicationFactory extends MaestrocliApplicationFactory implements TestApplicationFactory {

    private int databaseVersion;

    public MaestrocliTestApplicationFactory() {
        super(MaestrocliApplicationFactory.BASENAME + "_test");
    }

    @Override
    public void setDatabaseVersion(int databaseVersion) {
        this.databaseVersion = databaseVersion;
    }

    @Override
    public DatabaseUpdater getDatabaseUpdater() {
        // TODO Extrair este código para uma classe
        // AbstractTestApplicationFactory, pois todo o TestApplicationFactory
        // vai fazer do mesmo jeito
        return getDatabaseUpdater(databaseVersion);
    }

    @Override
    public DatabaseUpdater getBeforeTestsDatabaseUpdater() {
        // TODO Extrair este código para uma classe
        // AbstractTestApplicationFactory, pois todo o TestApplicationFactory
        // vai fazer do mesmo jeito

        if (databaseVersion == 0)
            return null;
        else
            return getDatabaseUpdater(databaseVersion - 1);
    }

    private DatabaseUpdater getDatabaseUpdater(int updaterVersion) {
        ConnectionSource connection = connectionManager.getConnection();

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
