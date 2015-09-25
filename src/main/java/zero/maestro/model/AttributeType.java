package zero.maestro.model;

public enum AttributeType {

    VIEW("view"), FIXEDTAGLIST("fixedtaglist"), REGEXTAGLIST("regextaglist"), TEXT("text"), DATETIME("datetime"), INTEGER("integer"), GPS("gps");

    private String name;

    AttributeType(String name) {
        this.name = name;
    }

    public static AttributeType getAttributeTypeByName(String attributeTypeName) {
        for (AttributeType attributeType : values())
            if (attributeType.name.equals(attributeTypeName))
                return attributeType;

        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
