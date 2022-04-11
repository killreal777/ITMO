package commands.server_simple_commands;

import commands.abstractions.Command;
import commands.abstractions.ServerCommand;
import data_xml.subject_area_structure.Organization;

public class Show extends ServerCommand {
    @Override
    public Command getClone() {
        return new Show();
    }

    @Override
    public void setArgs(String[] args) {

    }

    @Override
    public void execute() {
        if (dataManager.getCollection().iterator().hasNext()) {
            for (Organization org : dataManager.getCollection())
                this.result += org.toString();
        } else
            this.result += "Коллекция пуста";
    }


    @Override
    public String getHelp() {
        String name = "show";
        String description = "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
        return String.format("%s: %s", name, description);
    }
}
