package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.easymvc.EasyMVCException;
import zero.maestro.app.dao.TagDao;
import zero.maestro.model.Tag;

public class TagCreateCommand {

    @Dependency
    private TagDao dao;

    @ArgumentsBean
    private TagCreateArguments arguments;

    @Bean
    private Tag tag;

    private static final char[] validCharacters = "abcdefghijklmnopqrstuvwxyz_0123456789".toCharArray();

    @CommandHandler(path = { "tag", "add" })
    public void execute() throws SQLException, EasyMVCException {
        String tagName = arguments.getName().toLowerCase();

        if (!checkTagName(tagName))
            throw new EasyMVCException("A tag name can contain onle the characters " + validCharacters.toString());

        tag = new Tag();

        tag.setName(tagName);

        dao.create(tag);
    }

    private boolean checkTagName(String tagName) {
        for (Character character : tagName.toCharArray())
            if (!isValidTagNameCharacter(character))
                return false;

        return true;
    }

    private boolean isValidTagNameCharacter(Character testingCharacter) {
        for (char validCharacter : validCharacters)
            if (validCharacter == testingCharacter)
                return true;

        return false;
    }
}
