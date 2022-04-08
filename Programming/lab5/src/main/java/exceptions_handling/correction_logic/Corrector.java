package exceptions_handling.correction_logic;

import exceptions_handling.exceptions.ArgumentValueException;
import exceptions_handling.exceptions.ArgumentsAmountException;
import user_interface.ReadingMode;
import user_interface.Terminal;
import exceptions_handling.correction_commands.*;
import exceptions_handling.exceptions.CorrectableException;

import java.util.Arrays;
import java.util.HashMap;

public class Corrector implements ArgumentCorrector {
    private final Terminal terminal;
    private final AttemptCounter attemptCounter;
    private final HashMap<String, CorrectionCommand> correctionCommands;
    private final HashMap<ExceptionType, String[]> availableCommandsSets;


    public Corrector(Terminal terminal) {
        this.terminal = terminal;
        this.attemptCounter = new AttemptCounter(terminal);
        this.correctionCommands = new HashMap<>();
        this.availableCommandsSets = new HashMap<>();

        correctionCommands.put("a", new AddArgs(terminal));
        correctionCommands.put("b", new BreakExecution(terminal));
        correctionCommands.put("i", new IgnoreExtraArgs(terminal));
        correctionCommands.put("r", new ReEnterArgs(terminal));

        String[] availableForNotNeedArgumentsException = {"i", "b"};
        String[] availableForTooManyArgumentsException = {"i", "r", "b"};
        String[] availableForTooLessArgumentsException = {"a", "r", "b"};
        String[] availableForIllegalValueException = {"r", "b"};
        availableCommandsSets.put(ExceptionType.NOT_NEED_ARGUMENTS, availableForNotNeedArgumentsException);
        availableCommandsSets.put(ExceptionType.TOO_MANY_ARGUMENTS, availableForTooManyArgumentsException);
        availableCommandsSets.put(ExceptionType.TOO_LESS_ARGUMENTS, availableForTooLessArgumentsException);
        availableCommandsSets.put(ExceptionType.ILLEGAL_VALUE, availableForIllegalValueException);
    }


    @Override
    public CorrectionResult getCorrectionResult(CorrectableException exception) {
        ExceptionType type = defineAmountExceptionType(exception);
        String[] availableCommandKeys = availableCommandsSets.get(type);
        describe(exception, type);
        return executeCorrectionCommand(exception, availableCommandKeys);
    }


    private ExceptionType defineAmountExceptionType(CorrectableException exception) {
        if (exception instanceof ArgumentValueException)
            return ExceptionType.ILLEGAL_VALUE;
        ArgumentsAmountException castedException = (ArgumentsAmountException) exception;
        if (castedException.getExpectedAmount() == 0)
            return ExceptionType.NOT_NEED_ARGUMENTS;
        if (castedException.getEnteredAmount() > castedException.getExpectedAmount())
            return ExceptionType.TOO_MANY_ARGUMENTS;
        return ExceptionType.TOO_LESS_ARGUMENTS;
    }

    private void describe(CorrectableException exception, ExceptionType type) {
        terminal.print(type.toString() + exception.getMessage());
        terminal.print("Для продолжения введите одну из следующих команд:");
        for (String key : availableCommandsSets.get(type))
            terminal.print(correctionCommands.get(key).getMan());
    }

    private CorrectionResult executeCorrectionCommand(CorrectableException exception, String[] keys) {
        String[] inputLine = terminal.readLine(ReadingMode.SPLIT);
        if (inputLine.length != 1 || !(Arrays.asList(keys).contains(inputLine[0]))) {
            attemptCounter.decrementAttempts();
            return executeCorrectionCommand(exception, keys);
        }
        return correctionCommands.get(inputLine[0]).execute(exception);
    }
}
