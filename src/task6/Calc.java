package task6;


import java.io.Serializable;
import java.util.Formatter;

public class Calc implements Serializable, Basic {

    private String perimeter;
    private String square;
    private String volume;

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("%-10.9s|%-15.10s|%-15.10s|", perimeter, square, volume);
        return fmt.toString();
    }

    public void setPerimeter(String perimeter) {
        this.perimeter = perimeter;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String Perimeter(int a, int b) {
        perimeter = (2 * (a + b) + "");
        return perimeter;
    }

    public String Perimeter(int a) {
        perimeter = (Math.round(2 * Math.PI * a) + "");
        return perimeter;
    }

    public String Volume(int a, int b, int c) {
        volume = (a * b * c + "");
        return volume;
    }

    public String Volume(int a, int b) {
        volume = (Math.round(Math.PI * Math.pow(a, 2) * b) + "");
        return volume;
    }

    public String Square(int a, int b) {
        square = (a * b + "");
        return square;
    }

    public String Square(int a) {
        square = (Math.round(Math.PI * Math.pow(a, 2)) + "");
        return square;
    }

    public String getPerimeter() {
        return perimeter;
    }

    public String getSquare() {
        return square;
    }

    public String getVolume() {
        return volume;
    }



}
