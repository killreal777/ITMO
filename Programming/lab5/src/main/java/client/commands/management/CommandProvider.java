package client.commands.management;

import client.exceptions_handling.exceptions.CorrectableException;
import client.exceptions_handling.exceptions.NoSuchCommandException;
import library.command.Command;

public interface CommandProvider {
    void prepareCommand(String name) throws NoSuchCommandException;
    Command getPreparedCommand(String[] args) throws CorrectableException;
}
