package zero.maestrocli.renderer;

import java.util.LinkedList;
import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.CollectionSizeExtractor;
import zero.listprinter.Column;
import zero.listprinter.DataExtractor;
import zero.listprinter.FormattedColumn;
import zero.listprinter.IDFormatter;
import zero.listprinter.IntegerFormatter;
import zero.listprinter.IterableConcatenator;
import zero.listprinter.IterableFormatter;
import zero.listprinter.ListPrinter;
import zero.listprinter.ListPrinterException;
import zero.listprinter.NoParamMethodExtractor;
import zero.listprinter.ReflectionFieldExtractor;
import zero.listprinter.SimpleColumn;
import zero.listprinter.StringFormatter;
import zero.maestro.model.Task;

public class TaskListRenderer {

    private List<Task> tasks;
    private String[] columns;
    private TaskNameAsTreeExtractor treeNameColumnExtractor;

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

        for (String column : columns) {
            int columnNameEnd = column.indexOf(':');

            String columnName;
            String parameters;

            if (columnNameEnd == -1) {
                columnName = column;
                parameters = "";
            } else {
                columnName = column.substring(0, columnNameEnd);
                parameters = column.substring(columnNameEnd + 1);
            }

            switch (columnName) {
            case "id": {
                defs.add(createIDColumn());
                break;
            }

            case "treename": {
                defs.add(createTreeNameColumn());
                break;
            }

            case "supertask": {
                defs.add(createSupertaskColumn());
                break;
            }

            case "subtaskcount": {
                defs.add(createSubtaskCountColumn());
                break;
            }

            case "tags": {
                defs.add(createTagsColumn());
                break;
            }

            case "tagcount": {
                defs.add(createTagCountColumn());
                break;
            }

            case "propertiesof": {
                defs.add(createPropertiesOfColumn(parameters));
                break;
            }

            case "property": {
                defs.add(createPropertyColumn(parameters));
                break;
            }
            }
        }

        return defs;
    }

    private Column createIDColumn() {
        return new FormattedColumn("ID", new ReflectionFieldExtractor("id"), IDFormatter.getInstance());
    }

    private Column createTreeNameColumn() {
        if (treeNameColumnExtractor == null)
            treeNameColumnExtractor = new TaskNameAsTreeExtractor(tasks);

        return new SimpleColumn("Hierarchy", treeNameColumnExtractor);
    }

    private Column createSupertaskColumn() {
        return new FormattedColumn("Supertask", new ReflectionFieldExtractor("superTask", new ReflectionFieldExtractor("name")), StringFormatter.getInstance());
    }

    private Column createSubtaskCountColumn() {
        return new FormattedColumn("#Tasks", new NoParamMethodExtractor("getSubTasks", new CollectionSizeExtractor()), IntegerFormatter.getInstance());
    }

    private Column createTagsColumn() {
        DataExtractor extractor = new NoParamMethodExtractor("getTaskTags", new IterableConcatenator(new ReflectionFieldExtractor("tag", new ReflectionFieldExtractor("name"))));
        return new FormattedColumn("Tags", extractor, new IterableFormatter(StringFormatter.getInstance()));
    }

    private Column createTagCountColumn() {
        return new FormattedColumn("#Tags", new NoParamMethodExtractor("getTaskTags", new CollectionSizeExtractor()), IntegerFormatter.getInstance());
    }

    private Column createPropertiesOfColumn(String tagName) {
        return new FormattedColumn("#" + tagName, new PropertiesOfTagExtractor(tagName), new PropertyMapFormatter());
    }

    private Column createPropertyColumn(String parameters) {
        StringBuilder builder = new StringBuilder();

        int separatorIndex = parameters.indexOf('.');
        String tagName = parameters.substring(0, separatorIndex);
        String attributeName = parameters.substring(separatorIndex + 1);

        builder.append("#");
        builder.append(tagName);
        builder.append(":");
        builder.append(attributeName);

        String title = builder.toString();

        return new FormattedColumn(title, new PropertyOfTagExtractor(tagName, attributeName), StringFormatter.getInstance());
    }

}
