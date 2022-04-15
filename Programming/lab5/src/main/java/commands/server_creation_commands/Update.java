package commands.server_creation_commands;

import commands.abstractions.CommandArgumentException;
import commands.abstractions.ServerCommand;
import commands.server_creation_commands.creators.OrganizationCreator;
import data.model.Organization;
import user_interface.Terminal;


public class Update extends ServerCommand {
    private final OrganizationCreator creator;
    protected final Terminal terminal;
    protected Organization organization;
    private int id;

    public Update(Terminal terminal) {
        this.name = "update id {element}";
        this.description = "обновить значение элемента коллекции, id которого равен заданному";
        this.creator = new OrganizationCreator(terminal);
        this.terminal = terminal;
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        try {
            this.id = Integer.parseInt(args[0]);
            this.organization = creator.create();
            this.organization.setId(id);
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
            dataManager.getCollection().add(this.organization);
            result = String.format("Обновлена оганизация \"%s\"", organization.getName());
            return;
        }
        result = "В коллекции нет элемента у указанным id";
    }
}
