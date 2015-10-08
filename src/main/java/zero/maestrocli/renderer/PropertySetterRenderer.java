package zero.maestrocli.renderer;

import zero.easymvc.Bean;
import zero.easymvc.Renderer;
import zero.listprinter.ListPrinterException;
import zero.maestro.model.Property;

public class PropertySetterRenderer {

    @Bean
    private Property property;

    @Renderer(path = { "prop", "set" })
    public void render() throws ListPrinterException {
        String task = property.getTaskTag().getTask().getName();
        String tag = property.getAttribute().getTag().getName();
        String attribute = property.getAttribute().getName();
        String value = property.getValue();

        String message = String.format("\"%s\", \"%s\", \"%s\" created with value \"%s\".", task, tag, attribute, value);

        System.out.println(message);
    }
}
