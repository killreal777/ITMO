package commands.server_creation_commands;

import user_interface.Terminal;

public class AddIfMax extends Add {
    public AddIfMax(Terminal terminal) {
        super(terminal);
    }


    @Override
    public String getHelp() {
        String name = "add_if_max {element}";
        String description = "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
        return String.format("%s: %s", name, description);
    }
}
