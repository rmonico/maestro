package zero.maestrocli.renderer;

import zero.easymvc.Bean;
import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskRemoveRenderer {

    @Bean
    private Task removedTask;

    @Renderer(path = { "task", "rm" })
    public void render() {
    }

}
