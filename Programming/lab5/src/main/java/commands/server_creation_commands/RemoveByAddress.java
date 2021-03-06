package commands.server_creation_commands;

import commands.abstractions.ServerCommand;
import commands.server_creation_commands.creators.AddressCreator;
import model.Address;
import model.Organization;
import app.Terminal;


public class RemoveByAddress extends ServerCommand {
    private final AddressCreator creator;
    private Address address;


    public RemoveByAddress(Terminal terminal) {
        this.name = "remove_any_by_official_address {officialAddress}";
        this.description = "удалить из коллекции один элемент, значение поля officialAddress которого эквивалентно заданному";
        this.creator = new AddressCreator(terminal);
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 0);
        address = creator.create();
    }

    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection()) {
            if (!organization.getOfficialAddress().equals(address))
                continue;
            dataManager.getCollection().remove(organization);
            dataManager.getIdGenerator().setToRemoved(organization.getId());
            dataManager.getCollectionInfo().decrementElementsAmount();
            result = String.format("Удалена оганизация \"%s\"", organization.getName());
            return;
        }
        result = "В коллекции нет элемента у указанным адресом";
    }
}
