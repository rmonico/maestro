package zero.maestrocli.renderer;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Attribute;

public class AttributeCreateRenderer {

    private Attribute attribute;

    @Renderer(path = { "attr", "add" })
    public void render() throws ListPrinterException {
    }

}
