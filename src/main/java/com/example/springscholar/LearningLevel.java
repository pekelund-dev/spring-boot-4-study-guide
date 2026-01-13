package com.example.springscholar;

public enum LearningLevel {
    NEWBIE,
    PRO,
    HERO;

    public static LearningLevel from(String value) {
        if (value == null || value.isBlank()) {
            return NEWBIE;
        }
        return LearningLevel.valueOf(value.toUpperCase());
    }

    public boolean allows(String minLevel) {
        if (minLevel == null || minLevel.isBlank()) {
            return true;
        }
        return this.ordinal() >= LearningLevel.from(minLevel).ordinal();
    }
}
