package library.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement
public class Organization implements Comparable<Organization>{
    private Integer id; //not null, > 0, unique, autogenerate
    private String name; //not null, not empty String
    private Coordinates coordinates; //not null
    private java.time.LocalDateTime creationDate; //not null, autogenerate
    private Long annualTurnover; //not null, > 0
    private String fullName; //not null, unique
    private int employeesCount; //>0
    private OrganizationType type; //not null
    private Address officialAddress; //not null


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

    public Organization() {

    }


    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public Long getAnnualTurnover() {
        return annualTurnover;
    }
    public String getFullName() {
        return fullName;
    }
    public int getEmployeesCount() {
        return employeesCount;
    }
    public OrganizationType getType() {
        return type;
    }
    public Address getOfficialAddress() {
        return officialAddress;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setAnnualTurnover(Long annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }


    @Override
    public String toString() {
        String description = "";
        description += String.format("Name: \"%s\"\tFull name: \"%s\"\n",
                name, fullName);
        description += String.format("Type: %s\tAnnual turnover: %s\tEmployees count: %s\n",
                type, annualTurnover, employeesCount);
        description += String.format("Address: %s\tCoordinates: %s",
                officialAddress.toString(), coordinates.toString());
        return description;
    }

    @Override
    public int compareTo(Organization o) {
        if (annualTurnover > o.getAnnualTurnover())
            return 1;
        if (annualTurnover < o.getAnnualTurnover())
            return -1;
        return 0;
    }
}
