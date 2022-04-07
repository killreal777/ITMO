package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;

public class PrintAscending extends ServerCommand {
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
        String name = "print_ascending";
        String description = "вывести элементы коллекции в порядке возрастания";
        return String.format("%s: %s", name, description);
    }
}
