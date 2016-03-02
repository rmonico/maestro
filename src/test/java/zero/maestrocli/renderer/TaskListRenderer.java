package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Task;

public class TaskListRenderer {

    private List<Task> tasks;
    private String[] columns;
    //    private TaskNameAsTreeExtractor treeNameColumnExtractor;

    @Renderer(path = { "task", "ls" })
    public void render() throws ListPrinterException {
    }

}
