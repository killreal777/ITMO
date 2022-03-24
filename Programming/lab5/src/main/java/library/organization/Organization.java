package library.organization;


public class Organization implements Comparable<Organization>{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private String fullName; //Значение этого поля должно быть уникальным, Поле не может быть null
    private int employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address officialAddress; //Поле может быть null

    public Organization(String name, int coordinateX, int coordinateY, Long annualTurnover, String fullName,
                        int employeesCount, OrganizationType type, Address address) {
        this.name = name;
        this.coordinates = new Coordinates(coordinateX, coordinateY);
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = address;
    }


    public Long getAnnualTurnover() {
        return annualTurnover;
    }


    @Override
    public String toString() {
        return name + '\n' + coordinates + '\n' + annualTurnover + '\n' + fullName + '\n' + type + '\n' + officialAddress;
    }

    @Override
    public int compareTo(Organization o) {
        if (annualTurnover > o.getAnnualTurnover())
            return 1;
        return 0;
    }
}
