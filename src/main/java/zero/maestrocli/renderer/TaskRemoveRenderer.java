package zero.maestrocli.renderer;

import zero.easymvc.Bean;
import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskRemoveRenderer {

    @Bean
    private Task task;

    @Renderer(path = { "task", "rm" })
    public void render() {
        String message = String.format("Task #%d (\"%s\") removed.", task.getId(), task.getName());
        System.out.println(message);
    }
}
