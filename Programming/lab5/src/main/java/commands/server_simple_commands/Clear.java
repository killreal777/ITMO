package commands.server_simple_commands;

import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

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
        result += "Коллекция очищена";
    }


    @Override
    public String getHelp() {
        String name = "clear";
        String description = "очистить коллекцию";
        return String.format("%s: %s", name, description);
    }
}
