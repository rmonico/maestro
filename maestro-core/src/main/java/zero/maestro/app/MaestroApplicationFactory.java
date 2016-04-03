package zero.maestro.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import zero.easymvc.ormlite.ConnectionManager;
import zero.easymvc.ormlite.command.DatabaseUpdateCommand;
import zero.easymvc.ormlite.factory.ApplicationFactory;
import zero.environment.ApplicationPropertyKeys;
import zero.environment.Environment;
import zero.maestro.app.dao.AttributeDao;
import zero.maestro.app.dao.PropertyDao;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.database.DatabaseVersion_1;
import zero.maestro.model.Attribute;
import zero.maestro.model.Property;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

public class MaestroApplicationFactory extends ApplicationFactory {

    public static final String BASENAME = "maestro";
    public static final String EXECUTABLE_MAJOR_VERSION = "0";
    public static final String EXECUTABLE_MINOR_VERSION = "1";
    public static final String EXECUTABLE_PROJECT_PHASE = "beta";
    public static final String TASK_LIST_COLUMNS_PROPERTY_KEY = "task_list_columns";
    private static final String TASK_LIST_COLUMNS_DEFAULT = "id,treename";
    private ConnectionManager connectionManager;

    public MaestroApplicationFactory() {
        super(BASENAME);
    }

    protected MaestroApplicationFactory(String baseName) {
        super(baseName);
    }

    @Override
    public void makeProperties() throws IOException {
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MAJOR_VERSION_PROPERTY_KEY, EXECUTABLE_MAJOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MINOR_VERSION_PROPERTY_KEY, EXECUTABLE_MINOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_PROJECT_PHASE_PROPERTY_KEY, EXECUTABLE_PROJECT_PHASE);

        Environment.get().setProperty(TASK_LIST_COLUMNS_PROPERTY_KEY, TASK_LIST_COLUMNS_DEFAULT);

        super.makeProperties();
    }

    @Override
    protected void populateDaoInfo(Map<Class<?>, Class<?>> daoInfo) {
        super.populateDaoInfo(daoInfo);

        daoInfo.put(TaskDao.class, Task.class);
        daoInfo.put(TagDao.class, Tag.class);
        daoInfo.put(AttributeDao.class, Attribute.class);
        daoInfo.put(TaskTagDao.class, TaskTag.class);
        daoInfo.put(AttributeDao.class, Attribute.class);
        daoInfo.put(PropertyDao.class, Property.class);
    }

    @Override
    protected void createCommandList(List<Class<?>> commands) {
        super.createCommandList(commands);

        commands.add(TaskListCommand.class);
        commands.add(TagListCommand.class);
        commands.add(TagCreateCommand.class);
        commands.add(AttributeCreateCommand.class);
        commands.add(AttributeListCommand.class);
        commands.add(TaskCreateCommand.class);
        commands.add(TaskRemoveCommand.class);
        commands.add(TaskUpCommand.class);
        commands.add(TagRemoveCommand.class);
        commands.add(DatabaseUpdateCommand.class);
    }

    @Override
    public ConnectionManager makeConnectionManager() throws SQLException {
        connectionManager = super.makeConnectionManager();

        return connectionManager;
    }

    @Override
    public ConnectionManager createConnectionManager() throws SQLException {
        connectionManager = super.createConnectionManager();

        setDatabaseUpdater(new DatabaseVersion_1(connectionManager.getConnection()));

        return connectionManager;
    }

}
