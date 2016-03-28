package zero.maestrocli;

import zero.easymvc.EasyMVC;
import zero.easymvc.StringArrayCommand;

public class Main {

    public static void main(String[] args) throws Exception {
        Main main = new Main();

        main.run(args);
    }

    private void run(String[] args) throws Exception {
        MaestrocliApplicationFactory factory = new MaestrocliApplicationFactory();

        factory.makeProperties();

        factory.makeLogger();

        factory.makeConnectionManager();

        factory.makeDaoManager();

        EasyMVC controller = factory.makeController();

        controller.run(new StringArrayCommand(args));
    }

}
