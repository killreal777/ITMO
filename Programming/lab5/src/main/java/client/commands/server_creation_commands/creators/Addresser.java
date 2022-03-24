package client.commands.server_creation_commands.creators;

import client.exceptions_handling.exceptions.ArgumentValueException;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.user_interface.Terminal;
import library.command.Command;

public class Addresser extends Command {
    private final Terminal terminal;
    private final AddressCreator creator;
    private library.organization.Address address;
    private int status;

    public Addresser(Terminal terminal) {
        this.terminal = terminal;
        this.creator = new AddressCreator(terminal);
        this.status = 0;
    }

    @Override
    public Command getUsableClone() {
        return new Addresser(terminal);
    }

    @Override
    public void setArgs(String[] args) throws ArgumentsAmountException, ArgumentValueException {
        if (status == 0) {
            if (args.length != 0)
                throw new ArgumentsAmountException(args, 0);
            status = 1;
            creator.setReadArgs();
        } else {
            creator.setExternalArgs(args);
        }
       address = (library.organization.Address) creator.getResult();

    }

    @Override
    public void execute() {
        terminal.print("ВВААААУУУУ");
        terminal.print(address.toString());
    }
}
