package exceptions_handling.exceptions;

import user_interface.ReadingMode;

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
