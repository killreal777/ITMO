package NEW_CREATORS;

import data_xml.subject_area_structure.Location;
import user_interface.ReadingMode;
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
            case NAME: setX();
            case X: setY();
            case Y: setZ();
            case Z: setName();
        }
    }


    private void setX() throws RuntimeException {
        terminal.print("Введите координату X локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setX(Long.parseLong(input[0]));
            this.lastSetArgument = LocationArgument.X;
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа Long.");
        }
    }

    private void setY() {
        terminal.print("Введите координату Y локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setY(Integer.parseInt(input[0]));
            this.lastSetArgument = LocationArgument.Y;
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа int.");
        }
    }

    private void setZ() {
        terminal.print("Введите координату Z локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setZ(Long.parseLong(input[0]));
            this.lastSetArgument = LocationArgument.Z;
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа Float.");
        }
    }

    private void setName() {
        terminal.print("Введите название локации");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        creatingObject.setName(input[0]);
        this.lastSetArgument = LocationArgument.NAME;
    }
}



