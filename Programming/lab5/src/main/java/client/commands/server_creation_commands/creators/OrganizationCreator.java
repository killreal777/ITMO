package client.commands.server_creation_commands.creators;

import client.exceptions_handling.exceptions.ArgumentValueException;
import client.exceptions_handling.exceptions.ArgumentsAmountException;
import client.user_interface.ReadingMode;
import client.user_interface.Terminal;
import library.data.subject.Address;
import library.data.subject.Organization;
import library.data.subject.OrganizationType;

public class OrganizationCreator extends Creator {
    private final AddressCreator addressCreator;
    //private boolean isAddressCreationStarted;

    private String name;
    private int coordinateX;
    private int coordinateY;
    private Long annualTurnover;
    private String fullName;
    private int employeesCount;
    private OrganizationType type;


    public OrganizationCreator(Terminal terminal) {
        super(terminal);
        this.currentSetter = new NameSetter();
        this.addressCreator = new AddressCreator(terminal);
        //this.isAddressCreationStarted = false;
    }


    @Override
    protected void changeSetter() {
        if (this.currentSetter instanceof NameSetter)
            this.currentSetter = new CoordinateXSetter();
        else if (this.currentSetter instanceof CoordinateXSetter)
            this.currentSetter = new CoordinateYSetter();
        else if (this.currentSetter instanceof CoordinateYSetter)
            this.currentSetter = new AnnualTurnoverSetter();
        else if (this.currentSetter instanceof AnnualTurnoverSetter)
            this.currentSetter = new FullNameSetter();
        else if (this.currentSetter instanceof FullNameSetter)
            this.currentSetter = new EmployeesCountSetter();
        else if (this.currentSetter instanceof EmployeesCountSetter)
            this.currentSetter = new TypeSetter();
        else if (this.currentSetter instanceof TypeSetter)
            this.currentSetter = new AddressSetter();
        else
            isReady = true;
    }


    @Override
    public Object getResult() {
        Address address = (Address) addressCreator.getResult();
        return new Organization(name, coordinateX, coordinateY,
                annualTurnover, fullName, employeesCount, type, address);
    }


    private class NameSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.ENTIRE, "Введите название организации: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentValueException {
            if (args[0].equals(""))
                throw new ArgumentValueException(args, ReadingMode.ENTIRE, "Имя организации не может быть пустой строкой");
            name = args[0];
        }
    }


    private class CoordinateXSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите координату X организации: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                coordinateX = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип int");
            }
        }
    }


    private class CoordinateYSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите координату Y организации: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                coordinateY = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип int");
            }
        }
    }


    private class AnnualTurnoverSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите ежегодный оборот: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                annualTurnover = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип Long");
            }
        }
    }


    private class FullNameSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.ENTIRE, "Введите полное название организации: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentValueException {
            fullName = args[0];
        }
    }


    private class EmployeesCountSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String[] args = terminal.readLine(ReadingMode.SPLIT, "Введите количество сотрудников: ");
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                employeesCount = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось число, конвертируемое в тип int");
            }
        }
    }


    private class TypeSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            String message = "Выберите тип организации\n" +
                    "0 - коммерческая организация\n" +
                    "1 - траст\n" +
                    "2 - общество с ограниченной ответственностью\n" +
                    "3 - открытое акционерное общество\n" +
                    "Введите номер варианта: ";
            String[] args = terminal.readLine(ReadingMode.SPLIT, message);
            setArgument(args);
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            if (args.length != 1)
                throw new ArgumentsAmountException(args, 1);
            try {
                type = OrganizationType.getByID(Integer.parseInt(args[0]));
            } catch (NumberFormatException | OrganizationType.InvalidIDException e) {
                throw new ArgumentValueException(args, ReadingMode.SPLIT, "Ожидалось целое число от 0 до 3");
            }
        }
    }


    public class AddressSetter implements ArgumentSetter {
        @Override
        public void setArgument() throws ArgumentsAmountException, ArgumentValueException {
            setArgument(terminal.readLine(ReadingMode.SPLIT, "Введите zipCode: "));
        }
        @Override
        public void setArgument(String[] args) throws ArgumentsAmountException, ArgumentValueException {
            addressCreator.setExternalArgs(args);
        }
    }
}
