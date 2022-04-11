package NEW_CREATORS;

import data_xml.subject_area_structure.Address;
import data_xml.subject_area_structure.Coordinates;
import data_xml.subject_area_structure.Location;
import data_xml.subject_area_structure.Organization;
import user_interface.Terminal;
import user_interface.UserTerminal;

public class TestMain {
    public static void main(String[] args) {
        Terminal terminal = new UserTerminal();

        //Creator<Location> locationCreator = new LocationCreator(terminal);
        //terminal.print(locationCreator.create().toString());

        //Creator<Coordinates> coordinatesCreator = new CoordinatesCreator(terminal);
        //terminal.print(coordinatesCreator.create().toString());

        //Creator<Address> addressCreator = new AddressCreator(terminal);
        //terminal.print(addressCreator.create().toString());

        Creator<Organization> organizationCreator = new OrganizationCreator(terminal);
        terminal.print(organizationCreator.create().toString());
    }
}
