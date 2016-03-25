package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Task;

public class TaskListRenderer {

    @SuppressWarnings("unused")
    private List<Task> tasks;
    @SuppressWarnings("unused")
    private String[] columns;

    @Renderer(path = { "task", "ls" })
    public void render() throws ListPrinterException {
    }

}
