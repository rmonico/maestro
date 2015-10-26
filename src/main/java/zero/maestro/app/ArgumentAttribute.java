package zero.maestro.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArgumentAttribute {

    private static final String FILE_NAME_VALUE_PREFIX = "@";
    private String name;
    private String value;

    public ArgumentAttribute(String name, String value) throws IOException {
        this.name = name;
        this.value = getValue(value);
    }

    private String getValue(String value) throws IOException {
        if (value.startsWith(FILE_NAME_VALUE_PREFIX)) {
            String fileName = value.substring(1);

            byte[] encoded = Files.readAllBytes(Paths.get(fileName));
            return new String(encoded, "UTF-8");
        }

        return value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

}
