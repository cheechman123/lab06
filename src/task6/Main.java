package task6;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<CircleRoom> circleRoomList = new ArrayList<>();

    public static void init() {
        for (int i = 0; i < 5; i++) {

            CircleRoom circleRoom = new CircleRoom((int) (Math.random() * 30), (int) (Math.random() * 30), (int) (Math.random() * 3 + 1));
            Calc calc = new Calc();
            calc.Perimeter(circleRoom.getWidth(), circleRoom.getLongitude());
            calc.Square(circleRoom.getWidth(), circleRoom.getLongitude());
            calc.Volume(circleRoom.getWidth(), circleRoom.getLongitude(), circleRoom.getHeight());
            circleRoom.setCalc(calc);
            circleRoomList.add(circleRoom);
        }
    }


    public static void main(String[] args) {

        System.out.println(new Room().PolimorphMethod());
        System.out.println(new CircleRoom().PolimorphMethod());

        Menu menu = new Menu();
        init();


        for (CircleRoom circleRoom : circleRoomList)
            System.out.println(circleRoom);
        System.out.println("//////////////////////////");

        AddNewRoom addNewRoom = new AddNewRoom();
        addNewRoom.setCircleRoomList(circleRoomList);

        MediumRoom mediumRoom = new MediumRoom();
        mediumRoom.setCircleRoomList(circleRoomList);

        SortRoom sortRoom = new SortRoom();
        sortRoom.setCircleRoomList(circleRoomList);

        SearchRoom searchRoom = new SearchRoom();
        searchRoom.setCircleRoomList(circleRoomList);
        searchRoom.setRoom(circleRoomList.get(circleRoomList.size() - 1));

        MinRoom minRoom = new MinRoom();
        minRoom.setCircleRoomList(circleRoomList);


        menu.addCommand(addNewRoom);
        menu.addCommand(mediumRoom);
        menu.addCommand(searchRoom);
        menu.addCommand(minRoom);
        menu.addCommand(sortRoom);


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                menu.execute(menu.getCommandList().get(i));
            }
        }).start();


    }
}
