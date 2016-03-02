package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

public class TagRemoveRenderer {

    @SuppressWarnings("unused")
    private Tag removedTag;
    @SuppressWarnings("unused")
    private List<Attribute> attributes;
    @SuppressWarnings("unused")
    private List<TaskTag> taskTags;

    @Renderer(path = { "tag", "rm" })
    public void render() {
    }

}
