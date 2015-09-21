package zero.maestrocli.renderer;

import java.util.LinkedList;
import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.BooleanFormatter;
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

    @Renderer(path = { "task", "ls" })
    public void render() throws ListPrinterException {
        ListPrinter printer = new ListPrinter();

        printer.setEntityName("Task", "Tarefas");

        printer.setColumnDefinitions(createColumnDefinitions());

        printer.setData(tasks);

        printer.print();
    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        defs.add(new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance()));
        defs.add(new FormattedColumn("Nome", new ReflectionFieldExtractor("name"), StringFormatter.getInstance()));
        defs.add(new FormattedColumn("Super task", new ReflectionFieldExtractor("superTask", new ReflectionFieldExtractor("name")), BooleanFormatter.getInstance()));

        return defs;
    }
}
