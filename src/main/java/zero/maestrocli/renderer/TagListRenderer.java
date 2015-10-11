package zero.maestrocli.renderer;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import zero.easymvc.Renderer;
import zero.listprinter.Column;
import zero.listprinter.DataExtractor;
import zero.listprinter.FormattedColumn;
import zero.listprinter.IDFormatter;
import zero.listprinter.IntegerFormatter;
import zero.listprinter.ListPrinter;
import zero.listprinter.ListPrinterException;
import zero.listprinter.ReflectionFieldExtractor;
import zero.listprinter.StringFormatter;
import zero.maestro.model.Tag;

public class TagListRenderer {

    private List<Tag> tags;
    private Map<Tag, Integer> taskCount;

    @Renderer(path = { "tag", "ls" })
    public void render() throws ListPrinterException {
        ListPrinter printer = new ListPrinter();

        printer.setEntityName("Tag", "Tags");

        printer.setColumnDefinitions(createColumnDefinitions());

        printer.setData(tags);

        printer.print();
    }

    private static class TaskCountExtractor implements DataExtractor {

        private Map<Tag, Integer> taskCount;

        public TaskCountExtractor(Map<Tag, Integer> taskCount) {
            this.taskCount = taskCount;
        }

        @Override
        public Object extract(Object data) throws ListPrinterException {
            Tag tag = (Tag) data;

            return taskCount.get(tag);
        }

    }

    private List<Column> createColumnDefinitions() {
        List<Column> defs = new LinkedList<>();

        defs.add(new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance()));
        defs.add(new FormattedColumn("Name", new ReflectionFieldExtractor("name"), StringFormatter.getInstance()));
        defs.add(new FormattedColumn("Tasks", new TaskCountExtractor(taskCount), IntegerFormatter.getInstance()));

        return defs;
    }
}
