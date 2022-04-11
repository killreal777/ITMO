package NEW_CREATORS;

import data_xml.subject_area_structure.Organization;
import data_xml.subject_area_structure.OrganizationType;
import user_interface.ReadingMode;
import user_interface.Terminal;


public class OrganizationCreator extends Creator<Organization> {
    private final CoordinatesCreator coordinatesCreator;
    private final AddressCreator addressCreator;
    private enum OrganizationArgument {NAME, COORDINATES, ANNUAL_TURNOVER, FULL_NAME, EMPLOYEES_COUNT, TYPE, ADDRESS}
    private OrganizationArgument lastSetArgument;


    protected OrganizationCreator(Terminal terminal) {
        super(terminal);
        this.coordinatesCreator = new CoordinatesCreator(terminal);
        this.addressCreator = new AddressCreator(terminal);
        this.lastSetArgument = OrganizationArgument.ADDRESS;
    }


    @Override
    protected Organization createNewInstance() {
        return new Organization();
    }

    @Override
    protected void defineArguments() throws CreationException {
        switch (lastSetArgument) {
            case ADDRESS: defineName();
            case NAME: defineCoordinates();
            case COORDINATES: defineAnnualTurnover();
            case ANNUAL_TURNOVER: defineFullName();
            case FULL_NAME: defineEmployeesCount();
            case EMPLOYEES_COUNT: defineType();
            case TYPE: defineAddress();
        }
    }


    private void defineName() {
        terminal.print("Введите название организации");
        String input = terminal.readLine(ReadingMode.ENTIRE)[0];
        if (input.equals(""))
            throw new CreationException("Название организации не может быть пустой строкой.");
        creatingObject.setName(input);
        this.lastSetArgument = OrganizationArgument.NAME;
    }

    private void defineCoordinates() {
        creatingObject.setCoordinates(coordinatesCreator.create());
        this.lastSetArgument = OrganizationArgument.COORDINATES;
    }

    private void defineAnnualTurnover() {
        terminal.print("Введите ежегодный товарооборот");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        Long annualTurnover = null;
        try {
            annualTurnover = Long.parseLong(input[0]);
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа Long.");
        }
        if (annualTurnover <= 0)
            throw new CreationException("Ежегодный товарооборот должен быть больше нуля.");
        creatingObject.setAnnualTurnover(annualTurnover);
        this.lastSetArgument = OrganizationArgument.ANNUAL_TURNOVER;
    }

    private void defineFullName() {
        terminal.print("Введите полное название организации");
        String input = terminal.readLine(ReadingMode.ENTIRE)[0];
        if (input.equals(""))
            throw new CreationException("Полное название организации не может быть пустой строкой.");
        creatingObject.setFullName(input);
        this.lastSetArgument = OrganizationArgument.FULL_NAME;
    }

    private void defineEmployeesCount() {
        terminal.print("Введите число сотрудников");
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        int employeesCount = 0;
        try {
            employeesCount = Integer.parseInt(input[0]);
        } catch (NumberFormatException e) {
            throw new CreationException("Ожидалось число типа int.");
        }
        if (employeesCount <= 0)
            throw new CreationException("Чилсо сотрудников должно быть больше нуля.");
        this.lastSetArgument = OrganizationArgument.EMPLOYEES_COUNT;
    }

    private void defineType() {
        String message = "Выберите тип организации\n" +
                "0 - коммерческая организация\n" +
                "1 - траст\n" +
                "2 - общество с ограниченной ответственностью\n" +
                "3 - открытое акционерное общество\n" +
                "Введите номер варианта: ";
        terminal.print(message);
        String[] input = terminal.readLine(ReadingMode.SPLIT);
        if (input.length != 1)
            throw new CreationException(String.format("Ожидался 1 аргумент (Вы ввели %s).", input.length));
        try {
            creatingObject.setType(OrganizationType.getByID(Integer.parseInt(input[0])));
        } catch (NumberFormatException | OrganizationType.InvalidIDException e) {
            throw new CreationException("Ожидалось целое число от 0 до 3");
        }
        this.lastSetArgument = OrganizationArgument.TYPE;
    }

    private void defineAddress() {
        creatingObject.setOfficialAddress(addressCreator.create());
        this.lastSetArgument = OrganizationArgument.ADDRESS;
    }
}
