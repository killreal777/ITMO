package commands.local_commands;

import commands.abstractions.Command;

public class EmptyCommand extends Command {
    @Override
    public Command getClone() {
        return null;
        // no clone
    }

    @Override
    public void setArgs(String[] args) {
        // no args
    }

    @Override
    public void execute() {
        // empty
    }


    @Override
    public String getHelp() {
        return null;
        // no help
    }
}
