package zero.maestrocli.renderer;

import zero.listprinter.DataExtractor;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Property;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

class PropertyOfTagExtractor implements DataExtractor {

    private String tagName;
    private String attributeName;

    public PropertyOfTagExtractor(String tagName, String attributeName) {
        this.tagName = tagName;
        this.attributeName = attributeName;
    }

    @Override
    public Object extract(Object data) throws ListPrinterException {
        Task task = (Task) data;

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
            if (attributeName.equals(property.getAttribute().getName())) {
                return property.getValue();
            }
        }

        return null;
    }
}