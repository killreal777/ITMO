package NEW_CREATORS;

import data_xml.subject_area_structure.Address;
import user_interface.ReadingMode;
import user_interface.Terminal;


public class AddressCreator extends Creator<Address> {
    private final LocationCreator locationCreator;
    private enum AddressArgument {ZIP_CODE, TOWN}
    private AddressArgument lastSetArgument;


    protected AddressCreator(Terminal terminal) {
        super(terminal);
        this.locationCreator = new LocationCreator(terminal);
        this.lastSetArgument = AddressArgument.TOWN;
    }


    @Override
    protected Address createNewInstance() {
        return new Address();
    }

    @Override
    protected void defineArguments() throws CreationException {
        switch (lastSetArgument) {
            case TOWN: defineZipCode();
            case ZIP_CODE: defineTown();
        }
    }


    private void defineZipCode() {
        terminal.print("Введите Zip Code организации");
        String input = terminal.readLine(ReadingMode.ENTIRE)[0];
        if (input.equals(""))
            throw new CreationException("Zip Code не может быть пустой строкой.");
        creatingObject.setZipCode(input);
        this.lastSetArgument = AddressArgument.ZIP_CODE;
    }

    private void defineTown() {
        creatingObject.setTown(locationCreator.create());
        this.lastSetArgument = AddressArgument.TOWN;
    }
}
