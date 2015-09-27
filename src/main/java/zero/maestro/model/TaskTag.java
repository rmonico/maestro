package zero.maestro.model;

import zero.maestro.app.dao.TaskTagDao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(daoClass = TaskTagDao.class)
public class TaskTag {

    public static final String ID_FIELD_NAME = "id";
    public static final String TASK_FIELD_NAME = "task_id";
    public static final String TAG_FIELD_NAME = "tag_id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Task task;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Tag tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
