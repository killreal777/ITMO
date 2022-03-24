package client.commands.management;

import library.command.Command;

public class EmptyCommand extends Command {
    @Override
    public Command getUsableClone() {
        return null;
    }

    @Override
    public void setArgs(String[] args) {
    }

    @Override
    public void execute() {
    }
}
