package NEW_CREATORS;

import data_xml.subject_area_structure.Location;
import user_interface.Terminal;
import user_interface.UserTerminal;

public class TestMain {
    public static void main(String[] args) {
        Terminal terminal = new UserTerminal();
        Creator<Location> creator = new LocationCreator(terminal);
        terminal.print(creator.create().toString());
    }
}
