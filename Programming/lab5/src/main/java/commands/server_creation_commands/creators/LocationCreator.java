package commands.server_creation_commands.creators;

import data.model.Location;
import user_interface.Terminal.ReadingMode;
import user_interface.Terminal;


public class LocationCreator extends Creator<Location> {
    private enum LocationArgument {X, Y, Z, NAME}
    private LocationArgument lastSetArgument;


    public LocationCreator(Terminal terminal) {
        super(terminal);
        this.lastSetArgument = LocationArgument.NAME;
    }


    @Override
    protected Location createNewInstance() {
        return new Location();
    }

    @Override
    protected void defineArguments() {
        switch (lastSetArgument) {
            case NAME: defineX();
            case X: defineY();
            case Y: defineZ();
            case Z: defineName();
        }
    }


    private void defineX() throws RuntimeException {
        terminal.print("Введите координату X локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setX(Long.parseLong(input[0]));
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа Long.");
        }
        this.lastSetArgument = LocationArgument.X;
    }

    private void defineY() {
        terminal.print("Введите координату Y локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setY(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа int.");
        }
        this.lastSetArgument = LocationArgument.Y;
    }

    private void defineZ() {
        terminal.print("Введите координату Z локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setZ(Long.parseLong(input[0]));
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа Float.");
        }
        this.lastSetArgument = LocationArgument.Z;
    }

    private void defineName() {
        terminal.print("Введите название локации");
        String input = terminal.readLine(ReadingMode.ENTIRE)[0];
        if (input.equals(""))
            throw new CreationException("Название локации не может быть пустой строкой.");
        creatingObject.setName(input);
        this.lastSetArgument = LocationArgument.NAME;
    }
}



