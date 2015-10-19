package zero.maestrocli.renderer;

import java.util.LinkedHashMap;
import java.util.Map;

import zero.listprinter.DataExtractor;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Property;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

class PropertiesOfTagExtractor implements DataExtractor {

    private String tagName;

    public PropertiesOfTagExtractor(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public Object extract(Object data) throws ListPrinterException {
        Task task = (Task) data;

        Map<String, Object> values = new LinkedHashMap<String, Object>();

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