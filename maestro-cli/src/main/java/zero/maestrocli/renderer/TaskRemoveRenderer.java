package zero.maestrocli.renderer;

import zero.easymvc.Bean;
import zero.easymvc.Renderer;
import zero.maestro.model.Task;

public class TaskRemoveRenderer {

    @Bean
    private Task removedTask;

    @Renderer(path = { "task", "rm" })
    public void render() {
        String message = String.format("Task #%d (\"%s\") removed.", removedTask.getId(), removedTask.getName());
        System.out.println(message);

        notifySubtasksRemoval();
    }

    private void notifySubtasksRemoval() {
        for (Task subtask : removedTask.getSubTasks()) {
            String message = String.format("  Subtask #%d (\"%s\") removed.", subtask.getId(), subtask.getName());
            System.out.println(message);
        }
    }
}
