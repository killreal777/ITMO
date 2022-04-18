package commands.local_commands;

import commands.abstractions.Command;
import commands.abstractions.CommandArgumentException;
import user_interface.Terminal;

import java.io.FileNotFoundException;

public class ExecuteScript extends Command {
    private final Terminal terminal;
    private String scriptPath;


    public ExecuteScript(Terminal terminal) {
        this.name = "execute_script file_name";
        this.description = "считать и исполнить скрипт из указанного файла";
        this.terminal = terminal;
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        this.scriptPath = args[0];
    }


    @Override
    public void execute() {
        try {
            terminal.readScript(scriptPath);
            result = String.format("Скрипт %s начал исполняться", scriptPath);
        } catch (FileNotFoundException e) {
            result = String.format("Файл со скриптом %s не найден (возможно, файл закрыт для чтения)", scriptPath);
            throw new CommandArgumentException(result);
        } catch (IllegalArgumentException e) {
            result = String.format("Обнаружена рекурсия. Скрипт %s не будет исполнен", scriptPath);
            throw new CommandArgumentException(result);
        }
    }
}
