package zero.maestro.model;

import java.util.List;

import zero.maestro.app.dao.TaskDao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(daoClass = TaskDao.class)
public class Task {

    public static final String ID_FIELD_NAME = "id";
    public static final String NAME_FIELD_NAME = "name";
    public static final String SUPERTASK_FIELD_NAME = "supertask_id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField(foreign = true, canBeNull = true, foreignAutoRefresh = true)
    private Task superTask;
    private List<Tag> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Task getSuperTask() {
        return superTask;
    }

    public void setSuperTask(Task superTask) {
        this.superTask = superTask;
    }

    public void setTags(List<Tag> tagList) {
        this.tags = tagList;
    }

    public List<Tag> getTags() {
        return tags;
    }

}
