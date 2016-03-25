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

public class AttributeCreateRenderer {

    private Tag changedTag;

    @Renderer(path = { "attr", "add" })
    public void render() throws ListPrinterException {
        System.out.println("Tag \"%s\":");

        ListPrinter printer = new ListPrinter();

        printer.setEntityName("Attribute", "Attributes");

        printer.setColumnDefinitions(createColumnDefinitions());

        printer.setData(changedTag.getAttributes());

        printer.print();

    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        defs.add(new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance()));
        defs.add(new FormattedColumn("Name", new ReflectionFieldExtractor("name"), StringFormatter.getInstance()));
        defs.add(new FormattedColumn("Super task", new ReflectionFieldExtractor("type"), StringFormatter.getInstance()));

        return defs;
    }

}
