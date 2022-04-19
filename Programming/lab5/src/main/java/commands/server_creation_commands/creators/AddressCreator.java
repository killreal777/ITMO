package commands.server_creation_commands.creators;

import model.Address;
import model.FieldDefinitionException;
import app.Terminal;


public class AddressCreator extends Creator<Address> {
    private final LocationCreator locationCreator;
    private enum AddressArgument {ZIP_CODE, TOWN}
    private AddressArgument lastSetArgument;


    public AddressCreator(Terminal terminal) {
        super(terminal);
        this.locationCreator = new LocationCreator(terminal);
        this.lastSetArgument = AddressArgument.TOWN;
    }


    @Override
    protected Address createNewInstance() {
        return new Address();
    }

    @Override
    protected void defineFields() throws FieldDefinitionException {
        switch (lastSetArgument) {
            case TOWN: defineZipCode();
            case ZIP_CODE: defineTown();
        }
    }


    private void defineZipCode() {
        String input = terminal.readLineEntire("Введите Zip Code организации: " + formatRequirements("String, not null, length <= 16"));
        creatingObject.setZipCode(input);
        this.lastSetArgument = AddressArgument.ZIP_CODE;
    }

    private void defineTown() {
        creatingObject.setTown(locationCreator.create());
        this.lastSetArgument = AddressArgument.TOWN;
    }
}
