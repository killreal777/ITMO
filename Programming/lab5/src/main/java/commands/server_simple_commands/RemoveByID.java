package commands.server_simple_commands;

import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

public class RemoveByID extends ServerCommand {
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
        String name = "remove_by_id id";
        String description = " удалить элемент из коллекции по его id";
        return String.format("%s: %s", name, description);
    }
}