package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;
import zero.maestro.model.TaskTag;

public class TagRemoveRenderer {

    private Tag removedTag;
    private List<Attribute> attributes;
    private List<TaskTag> taskTags;

    @Renderer(path = { "tag", "rm" })
    public void render() {
    }

}
