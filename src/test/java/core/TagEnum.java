package core;

public enum TagEnum {
    ANDROID("@android"),
    WEB("@web"),
    API("@api");

    private final String value;

    TagEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}