package task6;


import java.io.Serializable;

public class CircleRoom extends Room implements Serializable {
    private Calc calc;

    public CircleRoom(int width, int longitude, int height) {
        super(width, longitude, height);
    }

    public CircleRoom() {

    }

    public Calc getCalc() {
        return calc;
    }

    public void setCalc(Calc calc) {
        this.calc = calc;
    }

    @Override
    public String PolimorphMethod(){
        return "Circle Room";
    }

    @Override
    public String toString() {
        return "CircleRoom{" +
                "calc=" + calc +
                '}';
    }
}
