package client.commands.local_commands;

import client.exceptions_handling.exceptions.ArgumentsAmountException;
import library.command.Command;

public class Exit extends Command {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void setArgs(String[] args) {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public Command getUsableClone() {
        return new Exit();
    }
}
