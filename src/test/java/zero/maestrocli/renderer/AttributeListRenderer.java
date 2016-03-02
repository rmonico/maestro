package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class AttributeListRenderer {

    private Tag tag;

    @Renderer(path = { "attr", "ls" })
    public void render() throws ListPrinterException {
    }

}
