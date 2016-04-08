package zero.maestro.app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.classic.Logger;
import zero.easymvc.EasyMVC;
import zero.easymvc.ormlite.ConnectionManager;
import zero.easymvc.ormlite.DaoManager;
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

public class MaestroApplicationFactory {

    public static final String BASENAME = "maestro";
    public static final String EXECUTABLE_MAJOR_VERSION = "0";
    public static final String EXECUTABLE_MINOR_VERSION = "1";
    public static final String EXECUTABLE_PROJECT_PHASE = "beta";
    public static final String TASK_LIST_COLUMNS_PROPERTY_KEY = "task_list_columns";
    private static final String TASK_LIST_COLUMNS_DEFAULT = "id,treename";
    private ApplicationFactory applicationFactoryDelegated;

    public MaestroApplicationFactory() {
        this(BASENAME);
    }

    public MaestroApplicationFactory(String baseName) {
        applicationFactoryDelegated = new ApplicationFactory(baseName);
    }

    public void makeProperties() throws IOException {
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MAJOR_VERSION_PROPERTY_KEY, EXECUTABLE_MAJOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_MINOR_VERSION_PROPERTY_KEY, EXECUTABLE_MINOR_VERSION);
        Environment.get().setProperty(ApplicationPropertyKeys.EXECUTABLE_PROJECT_PHASE_PROPERTY_KEY, EXECUTABLE_PROJECT_PHASE);

        Environment.get().setProperty(TASK_LIST_COLUMNS_PROPERTY_KEY, TASK_LIST_COLUMNS_DEFAULT);

        applicationFactoryDelegated.makeProperties();
    }

    public DaoManager makeDaoManager() {
        Map<Class<?>, Class<?>> daoInfo = new HashMap<>();

        daoInfo.put(TaskDao.class, Task.class);
        daoInfo.put(TagDao.class, Tag.class);
        daoInfo.put(AttributeDao.class, Attribute.class);
        daoInfo.put(TaskTagDao.class, TaskTag.class);
        daoInfo.put(AttributeDao.class, Attribute.class);
        daoInfo.put(PropertyDao.class, Property.class);

        return applicationFactoryDelegated.makeDaoManager(daoInfo);
    }

    public EasyMVC makeController() throws SQLException {
        EasyMVC controller = applicationFactoryDelegated.makeController();

        controller.registerCommandHandler(TaskListCommand.class);
        controller.registerCommandHandler(TagListCommand.class);
        controller.registerCommandHandler(TagCreateCommand.class);
        controller.registerCommandHandler(AttributeCreateCommand.class);
        controller.registerCommandHandler(AttributeListCommand.class);
        controller.registerCommandHandler(TaskCreateCommand.class);
        controller.registerCommandHandler(TaskRemoveCommand.class);
        controller.registerCommandHandler(TaskUpCommand.class);
        controller.registerCommandHandler(TagRemoveCommand.class);
        controller.registerCommandHandler(DatabaseUpdateCommand.class);

        return controller;
    }

    public ConnectionManager makeConnectionManager() throws SQLException {
        ConnectionManager connectionManager = applicationFactoryDelegated.makeConnectionManager();

        applicationFactoryDelegated.setDatabaseUpdater(new DatabaseVersion_1(connectionManager.getConnection()));

        return connectionManager;
    }

    public Logger makeLogger() {
        return applicationFactoryDelegated.makeLogger();
    }

}
