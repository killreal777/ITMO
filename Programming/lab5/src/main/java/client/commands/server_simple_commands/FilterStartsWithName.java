package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;

public class FilterStartsWithName extends ServerCommand {
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
        String name = "filter_starts_with_name name";
        String description = "вывести элементы, значение поля name которых начинается с заданной подстроки";
        return String.format("%s: %s", name, description);
    }
}
