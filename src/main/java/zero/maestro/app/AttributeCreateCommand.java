package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.maestro.model.Attribute;

public class AttributeCreateCommand {

    @ArgumentsBean
    private AttributeCreateArguments arguments;

    @Bean
    private Attribute attribute;

    @CommandHandler(path = { "attr", "add" })
    public void execute() throws SQLException {
    }

}
