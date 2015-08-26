package zero.maestro.model;

public class Task {

    private String name;
    private Task superTask;

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

}
