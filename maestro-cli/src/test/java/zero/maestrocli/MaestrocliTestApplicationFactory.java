package zero.maestrocli;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.j256.ormlite.support.ConnectionSource;

import zero.easymvc.ormlite.ConnectionManager;
import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.MetaInfUpdater;
import zero.maestro.database.DatabaseVersion_1;
import zero.utils.test.AbstractTestApplicationFactory;
import zero.utils.test.IApplicationFactory;
import zero.utils.test.TestApplicationFactory;

public class MaestrocliTestApplicationFactory extends MaestrocliApplicationFactory implements IApplicationFactory, TestApplicationFactory {

    private AbstractTestApplicationFactory testApplicationFactoryDelegated;

    public MaestrocliTestApplicationFactory() {
        this(AbstractTestApplicationFactory.DATABASE_LAST_VERSION);
    }

    public MaestrocliTestApplicationFactory(int databaseVersion) {
        super(MaestrocliApplicationFactory.BASENAME + "_test");

        testApplicationFactoryDelegated = new AbstractTestApplicationFactory(databaseVersion);
    }

    @Override
    public ConnectionManager makeConnectionManager() throws SQLException {
        ConnectionManager connectionManager = super.makeConnectionManager();

        ConnectionSource connection = connectionManager.getConnection();

        List<DatabaseUpdater> updaters = new LinkedList<DatabaseUpdater>();

        updaters.add(new MetaInfUpdater(connection));
        updaters.add(new DatabaseVersion_1(connection));

        testApplicationFactoryDelegated.addUpdaters(updaters);

        return connectionManager;
    }

    @Override
    public DatabaseUpdater getDatabaseUpdater() {
        return testApplicationFactoryDelegated.getDatabaseUpdater();
    }

    @Override
    public DatabaseUpdater getBeforeTestsDatabaseUpdater() {
        return testApplicationFactoryDelegated.getBeforeTestsDatabaseUpdater();
    }

}
