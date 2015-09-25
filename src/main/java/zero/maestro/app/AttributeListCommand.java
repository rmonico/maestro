package zero.maestro.app;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class AttributeListCommand {

    @Dependency
    private TagDao dao;

    @Bean
    private Tag tag;

    @CommandHandler(path = { "attr", "ls" })
    public void execute() {
    }

}
