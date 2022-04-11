package data_xml.subject_area_structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "town")
@XmlType(propOrder = {"x", "y", "z", "name"})
public class Location {
    private Long x; //not null
    private int y;
    private float z;
    private String name; //not null


    public Location(Long x, int y, float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Location() {}


    @XmlElement
    public Long getX() {
        return x;
    }

    @XmlElement
    public int getY() {
        return y;
    }

    @XmlElement
    public float getZ() {
        return z;
    }

    @XmlElement
    public String getName() {
        return name;
    }



    public void setX(Long x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format("%s (%d, %d, %f)", name, x, y, z);
        //return Long.toString(x) + "\n" + Integer.toString(y) + "\n" + Float.toString(z) + "\n" + name;
    }
}
