package management;

import commands.abstractions.Command;
import commands.abstractions.CommandArgumentException;
import commands.abstractions.ServerCommand;
import data.control.DataManager;
import user_interface.ReadingMode;
import user_interface.Terminal;
import user_interface.UserTerminal;

import java.util.Arrays;


public class ExecutionManager {
    private final Terminal terminal;
    private final CommandManager commandManager;
    private final DataManager dataManager;


    public ExecutionManager() {
        this.terminal = new UserTerminal();
        this.commandManager = new CommandManager(terminal);
        this.dataManager = new DataManager();
        terminal.print("Программа запущена \nДля вывода справки по доступным командам введите \"help\"");
    }


    public void executeNextCommand() {
        try {
            Command command = readCommand();
            executeCommand(command);
        } catch (CommandNotFoundException e) {
            terminal.print(e.getMessage());
        } catch (CommandArgumentException e) {
            terminal.print(e.getMessage());
        }
    }

    private Command readCommand() throws CommandNotFoundException {
        String[] inputLine = terminal.readLine(ReadingMode.SPLIT);
        if (inputLine.length == 0)
            return readCommand();   // empty input -> read command again
        String name = inputLine[0];
        String[] args = Arrays.copyOfRange(inputLine, 1, inputLine.length);
        return commandManager.getCommand(name, args);
    }

    private void executeCommand(Command command) {
        if (command instanceof ServerCommand)
            ((ServerCommand) command).setDataManager(dataManager);
        command.execute();

        terminal.print(command.getResult());
    }
}
