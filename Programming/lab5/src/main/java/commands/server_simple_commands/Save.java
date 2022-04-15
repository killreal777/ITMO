package commands.server_simple_commands;

import commands.abstractions.ServerCommand;


public class Save extends ServerCommand {
    public Save() {
        this.name = "save";
        this.description = "сохранить коллекцию в файл";
    }

    @Override
    public void execute() {
        this.dataManager.saveData();
    }
}
