package client.commands.local_commands;

import client.exceptions_handling.exceptions.ArgumentsAmountException;
import library.command.Command;

public class Exit extends Command{
    @Override
    public Command getClone() {
        return new Exit();
    }

    @Override
    public void setArgs(String[] args) {
        if (args.length != 0)
            throw new ArgumentsAmountException(args, 0);
    }

    @Override
    public void execute() {
        System.exit(0);
    }


    @Override
    public String getHelp() {
        String name = "exit";
        String description = "завершить программу (без сохранения в файл)";
        return String.format("%s: %s", name, description);
    }
}
