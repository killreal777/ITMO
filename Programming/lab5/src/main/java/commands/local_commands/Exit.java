package commands.local_commands;

import exceptions_handling.exceptions.ArgumentsAmountException;
import commands.abstractions.Command;

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
