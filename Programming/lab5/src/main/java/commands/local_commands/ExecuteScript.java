package commands.local_commands;

import commands.abstractions.Command;


public class ExecuteScript extends Command {
    public ExecuteScript() {
        super();
        this.name = "execute_script file_name";
        this.description = "считать и исполнить скрипт из указанного файла";
    }

    @Override
    public void execute() {
    }
}
