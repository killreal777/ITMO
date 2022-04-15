package commands.server_simple_commands;

import commands.abstractions.ServerCommand;
import data.model.Organization;


public class Clear extends ServerCommand {
    public Clear() {
        this.name = "clear";
        this.description = "очистить коллекцию";
    }

    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection())
            dataManager.getIdGenerator().removeId(organization.getId());
        dataManager.getCollection().clear();
        dataManager.getCollectionInfo().setElementsAmount(0);
        result = "Коллекция очищена";
    }
}
