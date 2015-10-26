package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class TagRemoveCommand {

    @ArgumentsBean
    private TagRemoveArguments args;

    @Dependency
    private TagDao dao;

    @Bean
    private Tag removedTag;

    @CommandHandler(path = { "tag", "rm" })
    public void execute() throws SQLException, EasyMVCException {
        removedTag = dao.queryForName(args.getTagName());

        // TODO Test
        // if (tag == null) {
        // String message = String.format("Unknown tag: \"%s\"",
        // args.getTagName());
        // throw new EasyMVCException(message);
        // }

        dao.delete(removedTag);
    }
}
