package commands.server_creation_commands.creators;

import exceptions_handling.exceptions.ArgumentValueException;
import exceptions_handling.exceptions.ArgumentsAmountException;

interface ArgumentSetter {
    void setArgument() throws ArgumentsAmountException, ArgumentValueException;
    void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException;
}
