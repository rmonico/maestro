package zero.maestrocli;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import zero.easymvc.ormlite.DatabaseVersion;
import zero.easymvc.ormlite.factory.ApplicationFactory;
import zero.environment.ApplicationPropertyKeys;
import zero.environment.Environment;
import zero.maestro.app.TaskListCommand;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.database.DatabaseVersion_1;
import zero.maestro.model.Task;
import zero.maestrocli.renderer.TaskListRenderer;

public class MaestrocliApplicationFactory extends ApplicationFactory {

    public static final String BASENAME = "maestro";
    public static final String EXECUTABLE_MAJOR_VERSION = "0";
    public static final String EXECUTABLE_MINOR_VERSION = "1";
    public static final String EXECUTABLE_PROJECT_PHASE = "beta";

    public MaestrocliApplicationFactory() {
        super(BASENAME);
    }

    protected MaestrocliApplicationFactory(String baseName) {
        super(baseName);
    }

    @Override
    public void makeProperties() throws IOException {
        super.makeProperties();

        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MAJOR_VERSION_PROPERTY_KEY, EXECUTABLE_MAJOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MINOR_VERSION_PROPERTY_KEY, EXECUTABLE_MINOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_PROJECT_PHASE_PROPERTY_KEY, EXECUTABLE_PROJECT_PHASE);
    }

    @Override
    protected void populateDaoInfo(Map<Class<?>, Class<?>> daoInfo) {
        super.populateDaoInfo(daoInfo);

        daoInfo.put(TaskDao.class, Task.class);
    }

    @Override
    protected void createCommandList(List<Class<?>> commands) {
        super.createCommandList(commands);

        commands.add(TaskListCommand.class);
    }

    @Override
    protected void createRendererList(List<Class<?>> renderers) {
        super.createRendererList(renderers);

        renderers.add(TaskListRenderer.class);
    }

    @Override
    protected DatabaseVersion createDatabaseVersion() throws Exception {
        return new DatabaseVersion_1(connectionManager.getConnection());
    }

}