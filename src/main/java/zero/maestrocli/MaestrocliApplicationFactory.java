package zero.maestrocli;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import zero.easymvc.ormlite.DatabaseUpdater;
import zero.easymvc.ormlite.command.DatabaseUpdateCommand;
import zero.easymvc.ormlite.factory.ApplicationFactory;
import zero.easymvc.ormlite.renderer.DatabaseUpdateRenderer;
import zero.environment.ApplicationPropertyKeys;
import zero.environment.Environment;
import zero.maestro.app.AttributeCreateCommand;
import zero.maestro.app.AttributeListCommand;
import zero.maestro.app.TagCreateCommand;
import zero.maestro.app.TagListCommand;
import zero.maestro.app.TagRemoveCommand;
import zero.maestro.app.TaskCreateCommand;
import zero.maestro.app.TaskListCommand;
import zero.maestro.app.TaskRemoveCommand;
import zero.maestro.app.TaskUpCommand;
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
import zero.maestrocli.renderer.AttributeCreateRenderer;
import zero.maestrocli.renderer.AttributeListRenderer;
import zero.maestrocli.renderer.TagCreateRenderer;
import zero.maestrocli.renderer.TagListRenderer;
import zero.maestrocli.renderer.TagRemoveRenderer;
import zero.maestrocli.renderer.TaskCreateRenderer;
import zero.maestrocli.renderer.TaskListRenderer;
import zero.maestrocli.renderer.TaskRemoveRenderer;
import zero.maestrocli.renderer.TaskUpRenderer;

public class MaestrocliApplicationFactory extends ApplicationFactory {

    public static final String BASENAME = "maestro";
    public static final String EXECUTABLE_MAJOR_VERSION = "0";
    public static final String EXECUTABLE_MINOR_VERSION = "1";
    public static final String EXECUTABLE_PROJECT_PHASE = "beta";
    public static final String TASK_LIST_COLUMNS_PROPERTY_KEY = "task_list_columns";
    private static final String TASK_LIST_COLUMNS_DEFAULT = "id,treename";

    public MaestrocliApplicationFactory() {
        super(BASENAME);
    }

    protected MaestrocliApplicationFactory(String baseName) {
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
    protected void createRendererList(List<Class<?>> renderers) {
        super.createRendererList(renderers);

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
    }

    @Override
    public DatabaseUpdater getDatabaseUpdater() {
        return new DatabaseVersion_1(connectionManager.getConnection());
    }

}
