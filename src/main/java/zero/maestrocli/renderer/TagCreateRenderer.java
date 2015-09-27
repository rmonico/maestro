package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class TagCreateRenderer {

    private Tag tag;

    @Renderer(path = { "tag", "add" })
    public void render() throws ListPrinterException {
        String message = String.format("New tag created: %s (#%d)", tag.getName(), tag.getId());

        System.out.println(message);
    }

}
