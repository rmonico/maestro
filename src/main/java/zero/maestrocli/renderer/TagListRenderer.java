package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class TagListRenderer {

    private List<Tag> tags;

    @Renderer(path = { "tag", "ls" })
    public void render() throws ListPrinterException {

    }
}
