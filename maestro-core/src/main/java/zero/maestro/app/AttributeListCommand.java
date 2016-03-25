package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class AttributeListCommand {

    @Dependency
    private TagDao dao;

    @ArgumentsBean
    private AttributeListArguments args;

    @Bean
    private Tag tag;

    @CommandHandler(path = { "attr", "ls" })
    public void execute() throws SQLException {
        String tagName = args.getTagName();

        tag = dao.queryForName(tagName);
    }

}
