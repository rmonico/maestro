package zero.maestrocli.renderer;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class TagListCommand {

    @Dependency
    private TagDao dao;

    @Bean
    private List<Tag> tags;

    @CommandHandler(path = { "tag", "ls" })
    public void execute() throws SQLException {
        tags = new LinkedList<Tag>();

        tags.add(newTag("first_tag"));
        tags.add(newTag("second_tag"));
        tags.add(newTag("third_tag"));
    }

    private Tag newTag(String string) {
        Tag tag = new Tag();

        tag.setName(string);

        return tag;
    }
}
