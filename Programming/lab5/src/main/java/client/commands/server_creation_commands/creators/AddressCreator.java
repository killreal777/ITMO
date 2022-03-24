package client.commands.server_creation_commands.creators;

import client.exceptions_handling.exceptions.ArgumentValueException;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.user_interface.ReadingMode;
import client.user_interface.Terminal;

import java.util.Arrays;

public class AddressCreator extends Creator {
    private String zipCode;
    private Long locationArgX;
    private int locationArgY;
    private float locationArgZ;
    private String locationArgName;


    public AddressCreator(Terminal terminal) {
        super(terminal);
        this.currentSetter = new ZipCodeSetter();
    }


    @Override
    protected void changeSetter() {
        if (this.currentSetter instanceof ZipCodeSetter)
            this.currentSetter = new LocationArgXSetter();
        else if (this.currentSetter instanceof LocationArgXSetter)
            this.currentSetter = new LocationArgYSetter();
        else if (this.currentSetter instanceof LocationArgYSetter)
            this.currentSetter = new LocationArgZSetter();
        else if (this.currentSetter instanceof LocationArgZSetter)
            this.currentSetter = new LocationArgNameSetter();
        else if (this.currentSetter instanceof LocationArgNameSetter)
            this.isReady = true;
    }


    @Override
    public Object getResult() {
        return new library.organization.Address(zipCode, locationArgX, locationArgY, locationArgZ, locationArgName);
    }


    private class ZipCodeSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите zipCode: ");
            System.out.println(Arrays.toString(args));
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            if (args[0].length() > 16)
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Длина zipCode должна быть меньше 16");
            zipCode = args[0];
        }
    }


    private class LocationArgXSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите координату X города: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                locationArgX = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип Long");
            }
        }
    }


    private class LocationArgYSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите координату Y города: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                locationArgY = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось целое число");
            }
        }
    }


    private class LocationArgZSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите координату Z города: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                locationArgZ = Float.parseFloat(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип float");
            }
        }
    }


    private class LocationArgNameSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.ENTIRE, "Введите название города: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentValueException {
            locationArgName = args[0];
        }
    }
}


