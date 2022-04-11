package commands.server_simple_commands;

import exceptions_handling.exceptions.ArgumentsAmountException;
import commands.abstractions.Command;
import commands.abstractions.ServerCommand;

public class Info extends ServerCommand {
    @Override
    public Command getClone() {
        return new Info();
    }

    @Override
    public void setArgs(String[] args) {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public void execute() {
        String collectionInfo = this.dataManager.getInfo();
        result += collectionInfo;
    }


    @Override
    public String getHelp() {
        String name = "info";
        String description = "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
        return String.format("%s: %s", name, description);
    }
}
