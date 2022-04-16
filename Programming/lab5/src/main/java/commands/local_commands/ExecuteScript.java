package commands.local_commands;

import commands.abstractions.Command;
import commands.abstractions.CommandArgumentException;
import user_interface.Terminal;

import java.io.FileNotFoundException;
import java.util.Stack;


public class ExecuteScript extends Command {
    private final static Stack<String> executingScripts = new Stack<>();
    private final Terminal terminal;


    public ExecuteScript(Terminal terminal) {
        this.name = "execute_script file_name";
        this.description = "считать и исполнить скрипт из указанного файла";
        this.terminal = terminal;
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        checkRecursion(args[0]);
        executingScripts.push(args[0]);
    }

    private void checkRecursion(String fileName) {
        if (executingScripts.contains(fileName)) {
            executingScripts.clear();
            result = String.format("Обнаружена рекурсия. Скрипт %s не будет исполнен.", fileName);
            throw new CommandArgumentException(result);
        }
    }


    @Override
    public void execute() {
        try {
            terminal.readFile(executingScripts.peek());
            result = String.format("Скрипт %s начал исполняться", executingScripts.peek());
        } catch (FileNotFoundException e) {
            result = "Указанный файл не найден (возможно, файл закрыт для чтения)";
        }
    }
}
