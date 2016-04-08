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
import zero.maestrocli.renderer.AttributeCreateRenderer;
import zero.maestrocli.renderer.AttributeListRenderer;
import zero.maestrocli.renderer.TagCreateRenderer;
import zero.maestrocli.renderer.TagListRenderer;
import zero.maestrocli.renderer.TagRemoveRenderer;
import zero.maestrocli.renderer.TaskCreateRenderer;
import zero.maestrocli.renderer.TaskListRenderer;
import zero.maestrocli.renderer.TaskRemoveRenderer;
import zero.maestrocli.renderer.TaskUpRenderer;
import zero.utils.test.AbstractTestApplicationFactory;
import zero.utils.test.TestApplicationFactory;

public class MaestroTestApplicationFactory implements TestApplicationFactory {

    private AbstractTestApplicationFactory testApplicationFactoryDelegated;
    private MaestroApplicationFactory maestroApplicationFactoryDelegated;

    public MaestroTestApplicationFactory() {
        this(AbstractTestApplicationFactory.DATABASE_LAST_VERSION);
    }

    public MaestroTestApplicationFactory(int databaseVersion) {
        maestroApplicationFactoryDelegated = new MaestroApplicationFactory(MaestroApplicationFactory.BASENAME + "_test");

        testApplicationFactoryDelegated = new AbstractTestApplicationFactory(databaseVersion);
    }

    @Override
    public ConnectionManager makeConnectionManager() throws SQLException {
        ConnectionManager connectionManager = maestroApplicationFactoryDelegated.makeConnectionManager();

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

    @Override
    public EasyMVC makeController() throws SQLException {
        EasyMVC controller = maestroApplicationFactoryDelegated.makeController();

        controller.registerRenderer(AttributeCreateRenderer.class);
        controller.registerRenderer(AttributeListRenderer.class);
        controller.registerRenderer(TagCreateRenderer.class);
        controller.registerRenderer(TagListRenderer.class);
        controller.registerRenderer(TagRemoveRenderer.class);
        controller.registerRenderer(TaskCreateRenderer.class);
        controller.registerRenderer(TaskListRenderer.class);
        controller.registerRenderer(TaskRemoveRenderer.class);
        controller.registerRenderer(TaskUpRenderer.class);

        return controller;
    }

    @Override
    public void makeProperties() throws IOException {
        maestroApplicationFactoryDelegated.makeProperties();
    }

    @Override
    public Logger makeLogger() {
        return maestroApplicationFactoryDelegated.makeLogger();
    }

    @Override
    public DaoManager makeDaoManager() {
        return maestroApplicationFactoryDelegated.makeDaoManager();
    }

}
