package client.commands.server_simple_commands;

import library.command.Command;
import library.command.ServerCommand;

public class Clear extends ServerCommand {
    @Override
    public Command getClone() {
        return new Clear();
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {
        dataManager.getCollection().clear();
        result.write("Коллекция очищена");
    }


    @Override
    public String getHelp() {
        String name = "clear";
        String description = "очистить коллекцию";
        return String.format("%s: %s", name, description);
    }
}
