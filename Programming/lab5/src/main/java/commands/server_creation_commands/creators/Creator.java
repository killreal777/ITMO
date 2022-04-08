package commands.server_creation_commands.creators;

import exceptions_handling.exceptions.ArgumentValueException;
import exceptions_handling.exceptions.ArgumentsAmountException;
import user_interface.Terminal;

public abstract class Creator {
    protected Terminal terminal;
    protected ArgumentSetter currentSetter;
    protected boolean isReady;


    public Creator(Terminal terminal) {
        this.terminal = terminal;
        this.isReady = false;
    }


    public void setReadArgs() throws ArgumentsAmountException, ArgumentValueException {
        if (isReady)
            return;
        currentSetter.setArgument();
        changeSetter();
        setReadArgs();
    }

    public void setExternalArgs(String[] args) throws ArgumentsAmountException, ArgumentValueException {
        currentSetter.setArgument(args);
        changeSetter();
        setReadArgs();
    }


    protected abstract void changeSetter();

    public abstract Object getResult();
}
