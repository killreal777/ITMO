package commands.server_creation_commands;

import commands.abstractions.Command;
import data_xml.subject_area_structure.Organization;
import user_interface.Terminal;

public class AddIfMax extends Add {
    public AddIfMax(Terminal terminal) {
        super(terminal);
    }

    @Override
    public Command getClone() {
        return new AddIfMax(this.terminal);
    }

    @Override
    public void execute() {
        for (Organization org : dataManager.getCollection()) {
            if (this.organization.compareTo(org) <= 0) {
                result = "Значение элемента не превышает значение наибольщего элемента в коллекции";
                return;
            }
        }
        dataManager.getCollection().add(this.organization);
        result = "Элемент успешно добавлен";
    }

    @Override
    public String getHelp() {
        String name = "add_if_max {element}";
        String description = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
        return String.format("%s: %s", name, description);
    }
}
