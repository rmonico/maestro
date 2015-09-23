package zero.maestro.app;

import zero.easymvc.PositionalParameter;

public class TagCreateArguments {

    @PositionalParameter
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
