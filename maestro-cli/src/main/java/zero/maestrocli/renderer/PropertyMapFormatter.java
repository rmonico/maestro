package zero.maestrocli.renderer;

import java.util.Map;

import zero.listprinter.Formatter;

class PropertyMapFormatter implements Formatter {

    @Override
    public String format(Object data) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values = (Map<String, Object>) data;

        StringBuilder builder = new StringBuilder("[");

        for (String attribute : values.keySet()) {
            builder.append(attribute);

            builder.append(":");

            String value = values.get(attribute).toString();
            builder.append(value);
            builder.append(";");
        }

        builder.delete(builder.length() - 1, builder.length());
        builder.append("]");

        return builder.toString();
    }
}