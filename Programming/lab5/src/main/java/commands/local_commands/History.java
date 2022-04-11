package commands.local_commands;

import exceptions_handling.exceptions.ArgumentsAmountException;
import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

public class History extends ServerCommand {
    @Override
    public Command getClone() {
        return new History();
    }

    @Override
    public void setArgs(String[] args) {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public void execute() {
        String history = this.dataManager.getHistory();
        this.result += history;
    }


    @Override
    public String getHelp() {
        String name = "history";
        String description = "вывести последние 10 команд (без их аргументов)";
        return String.format("%s: %s", name, description);
    }
}
