package commands.server_creation_commands;

import model.Organization;
import app.Terminal;


public class AddIfMax extends Add {
    public AddIfMax(Terminal terminal) {
        super(terminal);
        this.name = "add_if_max {element}";
        this.description = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }


    @Override
    public void execute() {
        for (Organization org : dataManager.getCollection()) {
            if (this.organization.compareTo(org) <= 0) {
                result = "Значение элемента не превышает значение наибольщего элемента в коллекции";
                return;
            }
        }
        super.execute();
    }
}
