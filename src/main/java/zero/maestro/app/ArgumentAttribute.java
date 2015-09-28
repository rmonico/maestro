package zero.maestro.app;

public class ArgumentAttribute {

    private String name;
    private String value;

    public ArgumentAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
