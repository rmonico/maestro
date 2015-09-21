package zero.maestrocli.renderer;

import java.util.LinkedList;
import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.Column;
import zero.listprinter.FormattedColumn;
import zero.listprinter.IDFormatter;
import zero.listprinter.ListPrinter;
import zero.listprinter.ListPrinterException;
import zero.listprinter.ReflectionFieldExtractor;
import zero.listprinter.StringFormatter;
import zero.maestro.model.Tag;

public class TagListRenderer {

    private List<Tag> tags;

    @Renderer(path = { "tag", "ls" })
    public void render() throws ListPrinterException {
        ListPrinter printer = new ListPrinter();

        printer.setEntityName("Tag", "Tags");

        printer.setColumnDefinitions(createColumnDefinitions());

        printer.setData(tags);

        printer.print();
    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        defs.add(new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance()));
        defs.add(new FormattedColumn("Name", new ReflectionFieldExtractor("name"), StringFormatter.getInstance()));

        return defs;
    }
}
