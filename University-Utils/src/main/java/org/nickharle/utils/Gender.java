package org.nickharle.utils;

public enum Gender {

    MALE("male"),
    FEMALE("female");

    private final String string;

    Gender(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}