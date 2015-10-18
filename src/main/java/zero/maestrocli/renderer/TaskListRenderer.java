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
        // ListPrinter printer = new ListPrinter();
        //
        // printer.setEntityName("Task", "Tasks");
        //
        // printer.setColumnDefinitions(createColumnDefinitions());
        //
        // printer.setData(tasks);
        //
        // printer.print();
        System.out.println();
        System.out.println("| ID | Name      | Subtasks | Tags             | #Tags | #sometag                                               | #othertag:someattr                       |");
        System.out.println();
        System.out.println("| #1 | Test task | 8        | sometag,othertag | 2     | [attr:value of attr in sometag on task #1;date:30/Mai] | Value of someattr in othertag on task #1 |");
        System.out.println();
        System.out.println();
    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        defs.add(new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance()));
        defs.add(new FormattedColumn("Name", new ReflectionFieldExtractor("name"), StringFormatter.getInstance()));
        defs.add(new FormattedColumn("Super task", new ReflectionFieldExtractor("superTask", new ReflectionFieldExtractor("name")), StringFormatter.getInstance()));

        return defs;
    }
}
