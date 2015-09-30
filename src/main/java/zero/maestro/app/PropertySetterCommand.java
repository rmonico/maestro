package zero.maestro.app;

import java.sql.SQLException;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.CommandHandler;
import zero.easymvc.EasyMVCException;

public class PropertySetterCommand {

    @ArgumentsBean
    private PropertySetterArguments args;

    @CommandHandler(path = { "prop", "set" })
    public void execute() throws SQLException, EasyMVCException {

    }
}
