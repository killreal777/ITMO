package client.exceptions_handling.exceptions;

import client.user_interface.ReadingMode;

public class ArgumentValueException extends CorrectableException {
    private final ReadingMode readingMode;

    public ArgumentValueException(String[] args, ReadingMode readingMode, String message) {
        super(args, message);
        this.readingMode = readingMode;
    }

    public ReadingMode getReadingMode() {
        return readingMode;
    }
}
