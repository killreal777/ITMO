package commands.server_creation_commands;

import commands.server_creation_commands.creators.OrganizationCreator;
import user_interface.Terminal;
import commands.abstractions.ServerCommand;
import data.model.Organization;

import java.time.LocalDateTime;


public class Add extends ServerCommand {
    private final OrganizationCreator creator;
    protected final Terminal terminal;
    protected Organization organization;


    public Add(Terminal terminal) {
        this.name = "add {element}";
        this.description = "добавить новый элемент в коллекцию";
        this.creator = new OrganizationCreator(terminal);
        this.terminal = terminal;
    }


    @Override
    public void setArgs(String[] args) {
        super.setArgs(args);
        organization = creator.create();
        organization.setCreationDate(LocalDateTime.now());
    }

    @Override
    public void execute() {
        int id = dataManager.getIdGenerator().generateId();
        organization.setId(id);
        this.dataManager.getCollection().add(organization);
        this.dataManager.getCollectionInfo().incrementElementsAmount();
        this.result = "Элемент успешно добавлен";
    }
}
