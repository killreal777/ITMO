package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;

public class Save extends ServerCommand {
    @Override
    public Command getClone() {
        return null;
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {

    }


    @Override
    public String getHelp() {
        String name = "save";
        String description = "сохранить коллекцию в файл";
        return String.format("%s: %s", name, description);
    }
}
