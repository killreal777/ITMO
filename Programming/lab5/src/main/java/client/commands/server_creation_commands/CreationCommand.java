package client.commands.server_creation_commands;

import client.commands.server_creation_commands.creators.Creator;
import client.user_interface.Terminal;
import library.command.ServerCommand;
import library.model.Address;
import library.model.Coordinates;
import library.model.OrganizationType;

abstract class CreationCommand extends ServerCommand {
    protected final Terminal terminal;
    protected final Creator creator;
    protected boolean isCreationStarted;

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Поле не может быть null
    private int employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address officialAddress; //Поле может быть null


    CreationCommand(Terminal terminal, Creator creator) {
        this.terminal = terminal;
        this.creator = creator;
        this.isCreationStarted = false;
    }
}
