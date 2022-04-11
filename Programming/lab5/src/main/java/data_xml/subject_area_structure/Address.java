package data_xml.subject_area_structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "official_address")
@XmlType(propOrder = {"zipCode", "town"})
public class Address {
    private String zipCode; //Длина строки не должна быть больше 16, not null
    private Location town; //not null

    public Address(String zipCode, Long x, int y, float z, String name) {
        this.zipCode = zipCode;
        this.town = new Location(x, y, x, name);
    }

    public Address() {}


    @XmlElement(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    @XmlElement(name = "town")
    public Location getTown() {
        return town;
    }


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setTown(Location town) {
        this.town = town;
    }


    @Override
    public String toString() {
        return zipCode + " " + town.toString();
    }
}
