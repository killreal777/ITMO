package library.model;

public class Coordinates {
    private int x; //Значение поля должно быть больше -535
    private int y; //Максимальное значение поля: 630

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }
}
