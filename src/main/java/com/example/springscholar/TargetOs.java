package com.example.springscholar;

public enum TargetOs {
    ANY,
    WINDOWS,
    LINUX,
    MAC,
    WSL;

    public static TargetOs from(String value) {
        if (value == null || value.isBlank()) {
            return ANY;
        }
        return TargetOs.valueOf(value.toUpperCase());
    }
}
