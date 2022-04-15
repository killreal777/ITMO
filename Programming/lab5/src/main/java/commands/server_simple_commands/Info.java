package commands.server_simple_commands;

import commands.abstractions.ServerCommand;


public class Info extends ServerCommand {
    public Info() {
        this.name = "info";
        this.description = "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }

    @Override
    public void execute() {
        String collectionInfo = this.dataManager.getInfo();
        result += collectionInfo;
    }
}
