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

    }
}
