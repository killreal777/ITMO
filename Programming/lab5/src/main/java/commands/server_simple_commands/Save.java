package commands.server_simple_commands;

import commands.abstractions.ServerCommand;

import java.io.FileNotFoundException;


public class Save extends ServerCommand {
    public Save() {
        this.name = "save";
        this.description = "сохранить коллекцию в файл";
    }

    @Override
    public void execute() {
        try {
            this.dataManager.saveData();
            result = "Коллекция сохранена";
        } catch (FileNotFoundException e) {
            result = "Невозможно сохранить коллекцию в файл: недостаточно прав";
        }


    }
}
