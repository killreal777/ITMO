package commands.server_creation_commands.creators;

import data.model.Coordinates;
import user_interface.Terminal.ReadingMode;
import user_interface.Terminal;

public class CoordinatesCreator extends Creator<Coordinates> {
    private enum CoordinatesArgument {X, Y}
    private CoordinatesArgument lastSetArgument;


    public CoordinatesCreator(Terminal terminal) {
        super(terminal);
        this.lastSetArgument = CoordinatesArgument.Y;
    }


    @Override
    protected Coordinates createNewInstance() {
        return new Coordinates();
    }

    @Override
    protected void defineArguments() throws CreationException {
        switch (lastSetArgument) {
            case Y: defineX();
            case X: defineY();
        }
    }


    private void defineX() throws RuntimeException {
        terminal.print("Введите координату X организации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setX(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа int.");
        }
        this.lastSetArgument = CoordinatesArgument.X;
    }

    private void defineY() {
        terminal.print("Введите координату Y организации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setY(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа int.");
        }
        this.lastSetArgument = CoordinatesArgument.Y;
    }
}
