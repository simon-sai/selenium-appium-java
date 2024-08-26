package core;

import lombok.Generated;

public enum Status {
    INFO("Info", 10),
    PASS("Pass", 20),
    WARNING("Warning", 30),
    SKIP("Skip", 40),
    FAIL("Fail", 50);

    private final Integer level;
    private final String name;

    private Status(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public String toLower() {
        return this.name.toLowerCase();
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Generated
    public Integer getLevel() {
        return this.level;
    }

    @Generated
    public String getName() {
        return this.name;
    }
}
