package JAXB.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "full_address")
@XmlType(propOrder = {"houseNumber", "streetName", "country"})
public class FullAddress {
    private Country country;
    private String streetName;
    private int houseNumber;

    public FullAddress(Country country, String streetName, int houseNumber) {
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public FullAddress() {  }

    @XmlElement(name = "country")
    public Country getCountry() {
        return country;
    }

    @XmlElement(name = "street_name")
    public String getStreetName() {
        return streetName;
    }

    @XmlElement(name = "house_number")
    public int getHouseNumber() {
        return houseNumber;
    }


    public void setCountry(Country country) {
        this.country = country;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }


    @Override
    public String toString() {
        return String.format("%s, %s %s", country, streetName, houseNumber);
    }
}
