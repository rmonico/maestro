package zero.maestrocli;

import java.util.List;

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

public class MaestrocliApplicationFactory extends MaestroApplicationFactory {

    public MaestrocliApplicationFactory() {
        super();
    }

    protected MaestrocliApplicationFactory(String baseName) {
        super(baseName);
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

}