package zero.maestrocli;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.classic.Logger;
import zero.easymvc.EasyMVC;
import zero.easymvc.ormlite.ConnectionManager;
import zero.easymvc.ormlite.DaoManager;
import zero.easymvc.ormlite.renderer.DatabaseUpdateRenderer;
import zero.maestro.app.MaestroApplicationFactory;
import zero.maestrocli.renderer.AttributeCreateRenderer;
import zero.maestrocli.renderer.AttributeListRenderer;
import zero.maestrocli.renderer.TagCreateRenderer;
import zero.maestrocli.renderer.TagListRenderer;
import zero.maestrocli.renderer.TagRemoveRenderer;
import zero.maestrocli.renderer.TaskCreateRenderer;
import zero.maestrocli.renderer.TaskListRenderer;
import zero.maestrocli.renderer.TaskRemoveRenderer;
import zero.maestrocli.renderer.TaskUpRenderer;

public class MaestrocliApplicationFactory {

    private MaestroApplicationFactory maestroApplicationFactoryDelegated;

    public MaestrocliApplicationFactory() {
        maestroApplicationFactoryDelegated = new MaestroApplicationFactory();
    }

    protected MaestrocliApplicationFactory(String baseName) {
        maestroApplicationFactoryDelegated = new MaestroApplicationFactory(baseName);
    }

    public EasyMVC makeController() throws SQLException {
        EasyMVC controller = maestroApplicationFactoryDelegated.makeController();

        List<Class<?>> renderers = new ArrayList<>();

        renderers.add(TaskListRenderer.class);
        renderers.add(TagListRenderer.class);
        renderers.add(TagCreateRenderer.class);
        renderers.add(AttributeCreateRenderer.class);
        renderers.add(AttributeListRenderer.class);
        renderers.add(TaskCreateRenderer.class);
        renderers.add(TaskRemoveRenderer.class);
        renderers.add(TaskUpRenderer.class);
        renderers.add(TagRemoveRenderer.class);
        renderers.add(DatabaseUpdateRenderer.class);

        maestroApplicationFactoryDelegated.registerRenderers(controller, renderers);

        return controller;
    }

    public void makeProperties() throws IOException {
        maestroApplicationFactoryDelegated.makeProperties();
    }

    public Logger makeLogger() {
        return maestroApplicationFactoryDelegated.makeLogger();
    }

    public ConnectionManager makeConnectionManager() throws SQLException {
        return maestroApplicationFactoryDelegated.makeConnectionManager();
    }

    public DaoManager makeDaoManager() {
        return maestroApplicationFactoryDelegated.makeDaoManager();
    }

}
