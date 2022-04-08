package commands.server_creation_commands;

import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

public class RemoveByAddress extends ServerCommand {
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
        String name = "remove_any_by_official_address officialAddress";
        String description = "удалить из коллекции один элемент, значение поля officialAddress которого эквивалентно заданному";
        return String.format("%s: %s", name, description);
    }
}
