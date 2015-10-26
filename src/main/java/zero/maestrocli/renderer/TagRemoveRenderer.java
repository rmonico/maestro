package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.maestro.model.Tag;

public class TagRemoveRenderer {

    private Tag removedTag;

    @Renderer(path = { "tag", "rm" })
    public void render() {
        String message = String.format("Tag \"%s\" removed.", removedTag.getName());
        System.out.println(message);
    }
}
