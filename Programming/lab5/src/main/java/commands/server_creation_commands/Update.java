package commands.server_creation_commands;

import commands.abstractions.CommandArgumentException;
import commands.abstractions.ServerCommand;
import commands.server_creation_commands.creators.OrganizationCreator;
import model.Organization;
import app.Terminal;

import java.time.LocalDateTime;


public class Update extends ServerCommand {
    protected final Terminal terminal;
    protected Organization organization;
    private int id;

    public Update(Terminal terminal) {
        this.name = "update id {element}";
        this.description = "обновить значение элемента коллекции, id которого равен заданному";
        this.terminal = terminal;
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        try {
            this.id = Integer.parseInt(args[0]);
            this.organization.setCreationDate(LocalDateTime.now());
            this.organization.setId(id);
        } catch (NumberFormatException e) {
            throw new CommandArgumentException("Неверный тип аргумента (ожидалось целое число типа Long)");
        }
    }


    @Override
    public void execute() {
        OrganizationCreator creator = new OrganizationCreator(terminal, dataManager.getCollection());
        for (Organization organization : dataManager.getCollection()) {
            if (organization.getId() != id)
                continue;
            dataManager.getCollection().remove(organization);
            this.organization = creator.create();
            dataManager.getCollection().add(this.organization);
            result = String.format("Обновлена оганизация \"%s\"", organization.getName());
            return;
        }
        result = "В коллекции нет элемента у указанным id";
    }
}
