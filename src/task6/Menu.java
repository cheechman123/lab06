package task6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu implements Queue{

    List<Command> commandList = new ArrayList<>();
    private boolean waiting;
    private boolean shutdown;

    Menu(){
        waiting = false;
    }

    void addCommand(Command command) {
        commandList.add(command);
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    void execute() {
        for (Command command : commandList) {
            command.execute();
            System.out.println("\n\n/////////////////////////");
        }
    }
    void execute(Command command){
        command.execute();
        System.out.println("\n\n/////////////////////////");
    }


    @Override
    public void put(Command cmd) {
        commandList.add(cmd);
        if(waiting){
            synchronized (this){
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if(commandList.isEmpty()){
            synchronized (this){
                waiting = true;
                try{
                    wait();
                } catch (InterruptedException e) {
                    waiting = false;
                }
            }
        }
        return (Command)commandList.remove(0);
    }

    private class Worker implements Runnable{

        @Override
        public void run() {
            while(!shutdown){
                Command c = take();
                c.execute();
            }
        }
    }
}
class AddNewRoom implements Command {

    List<CircleRoom> circleRoomList = new ArrayList<>();

    public List<CircleRoom> getCircleRoomList() {
        return circleRoomList;
    }

    public void setCircleRoomList(List<CircleRoom> circleRoomList) {
        this.circleRoomList = circleRoomList;
    }

    @Override
    public void execute() {
        circleRoomList.add(circleRoomList.get(0));
        System.out.println("added");
    }

}

class MinRoom implements Command {

    List<CircleRoom> circleRoomList = new ArrayList<>();

    public List<CircleRoom> getCircleRoomList() {
        return circleRoomList;
    }



    public void setCircleRoomList(List<CircleRoom> circleRoomList) {
        this.circleRoomList = circleRoomList;
    }

    @Override
    public void execute() {
        CircleRoom minCircleRoom = circleRoomList.get(0);
        for(CircleRoom circleRoom:circleRoomList){
            if(minCircleRoom.getHeight() > circleRoom.getHeight())
                minCircleRoom = circleRoom;
        }
        System.out.println("min room - " + minCircleRoom);

    }

}

class MediumRoom implements Command {

    List<CircleRoom> circleRoomList = new ArrayList<>();

    public List<CircleRoom> getCircleRoomList() {
        return circleRoomList;
    }

    public void setCircleRoomList(List<CircleRoom> circleRoomList) {
        this.circleRoomList = circleRoomList;
    }

    @Override
    public void execute() {

        int mediumSquare = 0;
        for (CircleRoom circleRoom : circleRoomList) {
            mediumSquare +=
                    Integer.parseInt(
                            circleRoom
                                    .getCalc()
                                    .getSquare());
        }
        mediumSquare /= circleRoomList.size();
        System.out.println("medium square = " + mediumSquare);
    }

}

class SortRoom implements Command {

    CircleRoom room;
    List<CircleRoom> circleRoomList = new ArrayList<>();

    public List<CircleRoom> getCircleRoomList() {
        return circleRoomList;
    }

    public void setCircleRoomList(List<CircleRoom> circleRoomList) {
        this.circleRoomList = circleRoomList;
    }

    public void setRoom(CircleRoom room) {
        this.room = room;
    }

    @Override
    public void execute() {
        Collections.sort(circleRoomList,
                Comparator.comparingInt(
                        (first) ->
                                Integer.parseInt(first
                                        .getCalc()
                                        .getSquare()
                                )
                )
        );
        for (CircleRoom circleRoom : circleRoomList)
            System.out.println(circleRoom);
        // (first, second)-> Integer.parseInt(first.getCalc().getSquare()) - Integer.parseInt(second.getCalc().getSquare()));
    }

}

class SearchRoom implements Command {
    CircleRoom room;
    List<CircleRoom> circleRoomList = new ArrayList<>();

    public void setRoom(CircleRoom room) {
        this.room = room;
    }

    public List<CircleRoom> getCircleRoomList() {
        return circleRoomList;
    }

    public void setCircleRoomList(List<CircleRoom> circleRoomList) {
        this.circleRoomList = circleRoomList;
    }

    @Override
    public void execute() {
        System.out.println("search - " + circleRoomList.get(circleRoomList.indexOf(room)));
    }
}