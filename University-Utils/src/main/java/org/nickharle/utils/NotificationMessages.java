package org.nickharle.utils;

public enum NotificationMessages {
    STUDENT_SAVE_VALIDATION_ERROR_TITLE("Error"),
    STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled")
    ;

    private final String string;

    NotificationMessages(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
