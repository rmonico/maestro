package zero.maestrocli.renderer;

import java.util.List;

import zero.easymvc.Bean;
import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskListRenderer {

    @Bean
    private List<Task> tasks;

    @Renderer(path = { "task", "ls" })
    public void render() {

    }
}
