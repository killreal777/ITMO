package commands.server_simple_commands;

import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

public class Save extends ServerCommand {
    @Override
    public Command getClone() {
        return new Save();
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {
        this.dataManager.saveData();
    }


    @Override
    public String getHelp() {
        String name = "save";
        String description = "сохранить коллекцию в файл";
        return String.format("%s: %s", name, description);
    }
}
