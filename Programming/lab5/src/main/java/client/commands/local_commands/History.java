package client.commands.local_commands;

import client.exceptions_handling.exceptions.ArgumentsAmountException;
import library.command.Command;
import library.command.ServerCommand;

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
        this.result.write(history);
    }


    @Override
    public String getHelp() {
        String name = "history";
        String description = "вывести последние 10 команд (без их аргументов)";
        return String.format("%s: %s", name, description);
    }
}
