package commands.local_commands;

import commands.abstractions.Command;

public class ExecuteScript extends Command {
    @Override
    public Command getClone() {
        return null;
    }

    @Override
    public void setArgs(String[] args) {
    }

    @Override
    public void execute() {
    }


    @Override
    public String getHelp() {
        String name = "execute_script file_name";
        String description = "считать и исполнить скрипт из указанного файла";
        return String.format("%s: %s", name, description);
    }
}
