package zero.maestrocli.renderer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import zero.easymvc.Renderer;
import zero.listprinter.CollectionSizeExtractor;
import zero.listprinter.Column;
import zero.listprinter.DataExtractor;
import zero.listprinter.FormattedColumn;
import zero.listprinter.Formatter;
import zero.listprinter.IDFormatter;
import zero.listprinter.IntegerFormatter;
import zero.listprinter.IterableConcatenator;
import zero.listprinter.IterableFormatter;
import zero.listprinter.ListPrinter;
import zero.listprinter.ListPrinterException;
import zero.listprinter.NoParamMethodExtractor;
import zero.listprinter.ReflectionFieldExtractor;
import zero.listprinter.StringFormatter;
import zero.maestro.model.Property;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

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

            case "name": {
                defs.add(createNameColumn());
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

    private static class PropertiesOfTagExtractor implements DataExtractor {

        private String tagName;

        public PropertiesOfTagExtractor(String tagName) {
            this.tagName = tagName;
        }

        @Override
        public Object extract(Object data) throws ListPrinterException {
            Task task = (Task) data;

            Map<String, Object> values = new HashMap<String, Object>();

            TaskTag selectedTag = null;
            for (TaskTag tt : task.getTaskTags()) {
                if (tagName.equals(tt.getTag().getName())) {
                    selectedTag = tt;

                    break;
                }
            }

            if (selectedTag == null)
                return null;

            for (Property property : selectedTag.getProperties()) {
                String attributeName = property.getAttribute().getName();
                String value = property.getValue();

                values.put(attributeName, value);
            }

            return values;
        }

    }

    private static class PropertyMapFormatter implements Formatter {

        @Override
        public String format(Object data) {
            @SuppressWarnings("unchecked")
            Map<String, Object> values = (Map<String, Object>) data;

            StringBuilder builder = new StringBuilder("[");

            for (String attribute : values.keySet()) {
                builder.append(attribute);

                builder.append(":");

                String value = values.get(attribute).toString();
                builder.append(value);
                builder.append(";");
            }

            builder.delete(builder.length() - 1, builder.length());
            builder.append("]");

            return builder.toString();
        }
    }

    private Column createPropertiesOfColumn(String tagName) {
        return new FormattedColumn("#" + tagName, new PropertiesOfTagExtractor(tagName), new PropertyMapFormatter());
    }

}
