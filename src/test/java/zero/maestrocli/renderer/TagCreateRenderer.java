package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class TagCreateRenderer {

    @SuppressWarnings("unused")
    private Tag tag;

    @Renderer(path = { "tag", "add" })
    public void render() throws ListPrinterException {
    }

}
