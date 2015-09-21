package zero.maestrocli.renderer;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class TagCreateCommand {

    @Dependency
    private TagDao dao;

    @ArgumentsBean
    private TagCreateArguments arguments;

    @Bean
    private Tag tag;

    @CommandHandler(path = { "tag", "add" })
    public void execute() throws SQLException {
        tag = new Tag();

        tag.setName(arguments.getName());

        dao.create(tag);
    }
}
