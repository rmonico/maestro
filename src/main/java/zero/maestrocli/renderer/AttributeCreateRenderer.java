package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class AttributeCreateRenderer {

    private Tag changedTag;

    @Renderer(path = { "attr", "add" })
    public void render() throws ListPrinterException {
    }

}
