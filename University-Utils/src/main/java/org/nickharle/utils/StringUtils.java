package org.nickharle.utils;

public enum StringUtils {

    MENU_STUDENT("STUDENTS"),
    MENU_ADD_STUDENT("Add Student"),
    MENU_REMOVE_STUDENT("Remove Student"),
    MENU_UNIVERSITY("UNIVERSITY"),
    MENU_OPERATIONS("Operations")

    ;

    private final String string;

    private StringUtils(String string) {
        this.string = string;
    }

    @Override public String toString() {
        return this.string;
    }

    public String getString() {
        return this.string;
    }
}
