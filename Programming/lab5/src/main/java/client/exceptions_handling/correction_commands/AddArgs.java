package client.exceptions_handling.correction_commands;

import client.exceptions_handling.correction_logic.CorrectionResult;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.exceptions_handling.exceptions.CorrectableException;
import client.user_interface.ReadingMode;
import client.user_interface.Terminal;

public class AddArgs implements CorrectionCommand {
    private final Terminal terminal;


    public AddArgs(Terminal terminal) {
        this.terminal = terminal;
    }


    @Override
    public CorrectionResult execute(CorrectableException exception) {
        ArgumentsAmountException argumentsAmountException = (ArgumentsAmountException) exception;
        String[] addedArgs = this.terminal.readLine(ReadingMode.SPLIT, "Введите недостающие аргументы: ");
        String[] newArgs = uniteStringArrays(argumentsAmountException.getArgs(), addedArgs);
        return new CorrectionResult(true, newArgs);
    }


    @Override
    public String getMan() {
        return "\033[1;93m" + "a" + "\033[0m" + ": " + "доввести недостающие аргументы";
    }


    private String[] uniteStringArrays(String[] a, String[] b) {
        int newLength = a.length + b.length;
        String[] newArray = new String[newLength];
        System.arraycopy(a, 0, newArray, 0, a.length);
        System.arraycopy(b, 0, newArray, a.length, b.length);
        return newArray;
    }
}
