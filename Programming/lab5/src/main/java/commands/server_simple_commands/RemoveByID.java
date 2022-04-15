package commands.server_simple_commands;

import commands.abstractions.CommandArgumentException;
import commands.abstractions.ServerCommand;
import data.model.Organization;


public class RemoveByID extends ServerCommand {
    private int id;


    public RemoveByID() {
        this.name = "remove_by_id id";
        this.description = " удалить элемент из коллекции по его id";
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        try {
            this.id = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new CommandArgumentException("Неверный тип аргумента (ожидалось целое число типа Long)");
        }
    }

    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection()) {
            if (organization.getId() != id)
                continue;
            dataManager.getCollection().remove(organization);
            dataManager.getIdGenerator().removeId(id);
            dataManager.getCollectionInfo().incrementElementsAmount();
            result = String.format("Удалена оганизация \"%s\"", organization.getName());
            return;
        }
        result = "В коллекции нет элемента у указанным id";
    }
}
