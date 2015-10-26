package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.maestro.model.Attribute;
import zero.maestro.model.Tag;

public class TagRemoveRenderer {

    private Tag removedTag;
    private List<Attribute> attributes;

    @Renderer(path = { "tag", "rm" })
    public void render() {
        showRemovedTag();

        showRemovedAttributes();
    }

    private void showRemovedTag() {
        String message = String.format("Tag \"%s\" removed.", removedTag.getName());
        System.out.println(message);
    }

    private void showRemovedAttributes() {
        for (Attribute attribute : attributes) {
            String attributeName = attribute.getName();
            String attributeType = attribute.getType().toString().toUpperCase();

            String message = String.format("Attribute \"%s\" (type %s) removed.", attributeName, attributeType);
            System.out.println(message);
        }
    }

}
