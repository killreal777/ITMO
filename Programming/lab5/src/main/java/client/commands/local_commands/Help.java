package client.commands.local_commands;

import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.user_interface.Terminal;
import library.command.Command;

import java.util.ArrayList;
import java.util.HashMap;

public class Help extends Command {
    private final ArrayList<String> commandDescriptions;

    public Help() {
        this.commandDescriptions = new ArrayList<>();
        setCommandDescriptions();
    }

    @Override
    public void execute() {
        for (String description : commandDescriptions)
            result.write(description);
    }

    @Override
    public void setArgs(String[] args) throws ArgumentsAmountException {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public Command getUsableClone() {
        return new Help();
    }

    private void setCommandDescriptions() {
        commandDescriptions.add("help - вывести справку по доступным командам");
        commandDescriptions.add("info - вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        commandDescriptions.add("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        commandDescriptions.add("add {element} : добавить новый элемент в коллекцию");
        commandDescriptions.add("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        commandDescriptions.add("clear : очистить коллекцию");
        commandDescriptions.add("save : сохранить коллекцию в файл");
        commandDescriptions.add("execute_script file_name : считать и исполнить скрипт из указанного файла");
        commandDescriptions.add("exit : завершить программу (без сохранения в файл)");
        commandDescriptions.add("head : вывести первый элемент коллекции");
        commandDescriptions.add("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        commandDescriptions.add("history : вывести последние 10 команд (без их аргументов)");
        commandDescriptions.add("filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки");
        commandDescriptions.add("print_ascending : вывести элементы коллекции в порядке возрастания");
    }
}
