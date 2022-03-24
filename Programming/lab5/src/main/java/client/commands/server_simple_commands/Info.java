package client.commands.server_simple_commands;

import client.exceptions_handling.exceptions.ArgumentsAmountException;
import library.command.Command;
import library.command.ServerCommand;

public class Info extends ServerCommand {
    @Override
    public void execute() {
        String collectionInfo = this.dataManager.getInfo();
        result.write(collectionInfo);
    }

    @Override
    public void setArgs(String[] args) {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public Command getUsableClone() {
        return new Info();
    }

    @Override
    public String toString() {
        return "info";
    }
}
