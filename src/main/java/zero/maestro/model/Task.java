package zero.maestro.model;

import java.util.Collection;
import java.util.LinkedList;

import zero.maestro.app.dao.TaskDao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
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

    @DatabaseField(foreign = true, canBeNull = true, foreignAutoRefresh = true, maxForeignAutoRefreshLevel = 3)
    private Task superTask;

    @ForeignCollectionField
    private Collection<TaskTag> taskTags;

    @ForeignCollectionField(orderColumnName = "id", orderAscending = false)
    private Collection<Task> subTasks;

    public Task() {
    }

    public Task(Task cloned) {
        this.id = cloned.id;
        this.name = cloned.name;
        this.superTask = cloned.superTask;
        this.taskTags = new LinkedList<>(cloned.taskTags);
        this.subTasks = new LinkedList<>(cloned.subTasks);
    }

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

    public Collection<TaskTag> getTaskTags() {
        return taskTags;
    }

    public Collection<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(Collection<Task> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id != other.id)
            return false;
        return true;
    }

}
