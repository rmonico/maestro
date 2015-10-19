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
import zero.maestro.model.Task;

public class TaskListRenderer {

    private List<Task> tasks;
    private String[] columns;

    @Renderer(path = { "task", "ls" })
    public void render() throws ListPrinterException {
        ListPrinter printer = new ListPrinter();

        printer.setEntityName("Task", "Tasks");

        printer.setColumnDefinitions(createColumnDefinitions());

        printer.setData(tasks);

        printer.print();
    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        for (String columnName : columns) {
            switch (columnName) {
            case "id": {
                defs.add(createIDColumn());
                break;
            }

            case "name": {
                defs.add(createNameColumn());
            }
            }
        }

        return defs;
    }

    private Column createIDColumn() {
        return new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance());
    }

    private Column createNameColumn() {
        return new FormattedColumn("Name", new ReflectionFieldExtractor("name"), StringFormatter.getInstance());
    }

}
