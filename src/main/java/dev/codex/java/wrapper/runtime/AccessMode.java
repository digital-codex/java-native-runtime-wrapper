package dev.codex.java.wrapper.runtime;

import java.util.Objects;

public final class AccessMode {
    public static final AccessMode READ = new AccessMode("r");
    public static final AccessMode WRITE = new AccessMode("w");
    public static final AccessMode APPEND = new AccessMode("a");
    public static final AccessMode READ_PLUS = new AccessMode("r+");
    public static final AccessMode WRITE_PLUS = new AccessMode("w+");
    public static final AccessMode APPEND_PLUS = new AccessMode("a+");

    private final String value;

    private AccessMode(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}