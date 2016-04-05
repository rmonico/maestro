package zero.maestrocli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.j256.ormlite.support.ConnectionSource;

import ch.qos.logback.classic.Logger;
import zero.easymvc.EasyMVC;
import zero.easymvc.ormlite.ConnectionManager;
import zero.easymvc.ormlite.DaoManager;
import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.MetaInfUpdater;
import zero.maestro.app.MaestroApplicationFactory;
import zero.maestro.database.DatabaseVersion_1;
import zero.utils.test.AbstractTestApplicationFactory;
import zero.utils.test.TestApplicationFactory;

public class MaestrocliTestApplicationFactory implements TestApplicationFactory {

    private AbstractTestApplicationFactory testApplicationFactoryDelegated;
    private MaestrocliApplicationFactory maestrocliApplicationFactoryDelegated;

    public MaestrocliTestApplicationFactory() {
        this(AbstractTestApplicationFactory.DATABASE_LAST_VERSION);
    }

    public MaestrocliTestApplicationFactory(int databaseVersion) {
        maestrocliApplicationFactoryDelegated = new MaestrocliApplicationFactory(MaestroApplicationFactory.BASENAME + "_test");

        testApplicationFactoryDelegated = new AbstractTestApplicationFactory(databaseVersion);
    }

    public ConnectionManager makeConnectionManager() throws SQLException {
        ConnectionManager connectionManager = maestrocliApplicationFactoryDelegated.makeConnectionManager();

        ConnectionSource connection = connectionManager.getConnection();

        List<DatabaseUpdater> updaters = new LinkedList<DatabaseUpdater>();

        updaters.add(new MetaInfUpdater(connection));
        updaters.add(new DatabaseVersion_1(connection));

        testApplicationFactoryDelegated.addUpdaters(updaters);

        return connectionManager;
    }

    @Override
    public void makeProperties() throws IOException {
        maestrocliApplicationFactoryDelegated.makeProperties();
    }

    @Override
    public Logger makeLogger() {
        return maestrocliApplicationFactoryDelegated.makeLogger();
    }

    @Override
    public DaoManager makeDaoManager() {
        return maestrocliApplicationFactoryDelegated.makeDaoManager();
    }

    @Override
    public EasyMVC makeController() throws SQLException {
        return maestrocliApplicationFactoryDelegated.makeController();
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
