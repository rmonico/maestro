package zero.maestro.model;

import zero.maestro.app.dao.PropertyDao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(daoClass = PropertyDao.class)
public class Property {

    public static final String ID_FIELD_NAME = "id";
    public static final String TASKTAG_FIELD_NAME = "tasktag_id";
    public static final String ATTRIBUTE_FIELD_NAME = "attribute_id";
    public static final String VALUE_FIELD_NAME = "value";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private TaskTag taskTag;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Attribute attribute;

    @DatabaseField
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TaskTag getTaskTag() {
        return taskTag;
    }

    public void setTaskTag(TaskTag taskTag) {
        this.taskTag = taskTag;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
