package org.nickharle.utils;

public enum StudentStringUtils {

    MAIN_MENU("MAIN MENU"),
    SHOW_ALL_STUDENTS("SHOW ALL STUDENTS"),
    FIRST_NAME("First name"),
    LAST_NAME("Last name"),
    AGE("Age"),
    GENDER("Gender"),
    SAVE_BUTTON("Save"),
    CLEAR_BUTTON("Clear")
    ;

    private final String string;

    StudentStringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}
