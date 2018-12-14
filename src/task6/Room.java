package task6;


import java.io.Serializable;


public class Room implements Serializable {

    private Calc calc;
    private int width;
    private int longitude;
    private int height;

    public Room(int width, int longitude, int height) {

        this.width = width;
        this.longitude = longitude;
        this.height = height;
    }

    public Room() {
    }

    public int getHeight() {

        return height;
    }

    public int getLongitude() {

        return longitude;
    }

    public int getWidth() {

        return width;
    }

    public Calc getCalc() {

        return calc;
    }

    public void setCalc(Calc calc) {

        this.calc = calc;
    }

    public String PolimorphMethod(){
        return "Room";
    }

}
