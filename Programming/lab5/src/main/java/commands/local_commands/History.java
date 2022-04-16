package commands.local_commands;

import commands.abstractions.ServerCommand;
import commands.CommandHistory;


public class History extends ServerCommand {
    private final CommandHistory history;

    public History(CommandHistory history) {
        this.name = "history";
        this.description = "вывести последние 10 команд (без их аргументов)";
        this.history = history;
    }

    @Override
    public void execute() {
        this.result = history.toString();
    }
}
