package zero.maestrocli.renderer;

import java.util.List;
import java.util.Map;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Tag;

public class TagListRenderer {

    private List<Tag> tags;
    private Map<Tag, Integer> taskCount;

    @Renderer(path = { "tag", "ls" })
    public void render() throws ListPrinterException {
    }

}
