package data.subject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "coordinates")
public class Coordinates {
    private int x; //Значение поля должно быть больше -535
    private int y; //Максимальное значение поля: 630

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {}


    @XmlElement
    public int getX() {
        return x;
    }

    @XmlElement
    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }
}
