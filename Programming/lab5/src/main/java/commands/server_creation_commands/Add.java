package commands.server_creation_commands;

import commands.server_creation_commands.creators.OrganizationCreator;
import app.Terminal;
import commands.abstractions.ServerCommand;
import model.Organization;

import java.time.LocalDateTime;


public class Add extends ServerCommand {
    protected final Terminal terminal;
    protected Organization organization;


    public Add(Terminal terminal) {
        this.name = "add {element}";
        this.description = "добавить новый элемент в коллекцию";
        this.terminal = terminal;
    }


    @Override
    public void execute() {
        OrganizationCreator creator = new OrganizationCreator(terminal, dataManager.getCollection());
        organization = creator.create();
        organization.setCreationDate(LocalDateTime.now());
        int id = dataManager.getIdGenerator().generateId();
        organization.setId(id);
        this.dataManager.getCollection().add(organization);
        this.dataManager.getCollectionInfo().incrementElementsAmount();
        this.result = "Элемент успешно добавлен";
    }
}
