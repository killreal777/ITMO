package client.exceptions_handling.correction_logic;

public enum ExceptionType {
    NOT_NEED_ARGUMENTS("Вы ввыли аргументы для команды, не требующей никаких аргументов "),
    TOO_MANY_ARGUMENTS("Вы ввели слишком много аргументов "),
    TOO_LESS_ARGUMENTS("Вы ввели слишком мало аргументов "),
    ILLEGAL_VALUE("Вы ввели неверный аргумент ");

    private final String description;

    ExceptionType(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
