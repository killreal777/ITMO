package main;

import commands.local_commands.EmptyCommand;
import exceptions_handling.correction_logic.ArgumentCorrector;
import exceptions_handling.correction_logic.CorrectionResult;
import exceptions_handling.correction_logic.Corrector;
import exceptions_handling.exceptions.CorrectableException;
import exceptions_handling.exceptions.NoSuchCommandException;
import commands.abstractions.Command;
import commands.abstractions.ServerCommand;
import user_interface.ReadingMode;
import user_interface.Terminal;
import user_interface.UserTerminal;

import java.util.Arrays;

public class ExecutionManager {
    private final Terminal terminal;
    private final CommandManager commandManager;
    private final ArgumentCorrector corrector;
    private final DataManager dataManager;
    private final CommandHistory history;


    public ExecutionManager() {
        this.terminal = new UserTerminal();
        this.commandManager = new CommandManager(terminal);
        this.corrector = new Corrector(terminal);
        this.dataManager = new DataManager();
        dataManager.loadData("src/main/java/data/data.xml");
        this.history = new CommandHistory();

        terminal.print("Программа запущена \nДля вывода справки по доступным командам введите \"help\"");
    }


    public void executeNextCommand() {
        try {
            String[] inputLine = terminal.readLine(ReadingMode.SPLIT);
            if (inputLine.length == 0)
                return;
            commandManager.prepareCommand(inputLine[0]);
            Command command = requestCommand(Arrays.copyOfRange(inputLine, 1, inputLine.length));
            executeCommand(command);
        } catch (NoSuchCommandException e) {
            terminal.print(e.getMessage());
        }
    }


    private Command requestCommand(String[] args) {
        try {
            return commandManager.getPreparedCommand(args);
        } catch (CorrectableException e) {
            CorrectionResult result = corrector.getCorrectionResult(e);
            if (result.isCorrectionRequested()) {
                String[] correctedArgs = result.getCorrectedArgs();
                return requestCommand(correctedArgs);
            } else
                return new EmptyCommand();
        }
    }


    private void executeCommand(Command command) {
        if (command instanceof ServerCommand)
            ((ServerCommand) command).setDataManager(dataManager);
        command.execute();
        history.addCommand(command);
        terminal.print(command.getResult().toString());
    }
}
