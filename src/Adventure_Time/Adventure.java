package Adventure_Time;

public class Adventure
{
    private Room currentRoom;

    Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
    Room room2 = new Room("Room 2", "A room with no distinct features, except two doors.");
    Room room3 = new Room("Room 3", "A room with no distinct features, except two doors.");
    Room room4 = new Room("Room 4", "A room with no distinct features, except two doors.");
    Room room5 = new Room("Room 5", "A room with no distinct features, except one door.");
    Room room6 = new Room("Room 6", "A room with no distinct features, except two doors.");
    Room room7 = new Room("Room 7", "A room with no distinct features, except two doors.");
    Room room8 = new Room("Room 8", "A room with no distinct features, except three doors.");
    Room room9 = new Room("Room 9", "A room with no distinct features, except two doors.");

    public Adventure()
    {
        currentRoom = room1;

        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setEast(room3);
        room2.setWest(room1);

        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setSouth(room7);
        room4.setNorth(room1);

        room5.setSouth(room8);

        room6.setSouth(room9);
        room6.setNorth(room3);

        room7.setEast(room8);
        room7.setNorth(room4);

        room8.setEast(room9);
        room8.setWest(room7);
        room8.setNorth(room5);

        room9.setWest(room8);
        room9.setNorth(room6);
    }
    public void look(){
        System.out.println(currentRoom.getName());
        System.out.println(currentRoom.getDescription());
    }

    public void wrongWay(){
        System.out.println("You can´t go that way.");
    }

    public void goNorth(){
        if (currentRoom.getNorth() != null){
            currentRoom = currentRoom.getNorth();
        }
        else {
            wrongWay();
        }
    }


    public void goEast(){
        if (currentRoom.getEast() != null){
            currentRoom = currentRoom.getEast();
        }
        else {
            wrongWay();
        }
    }

    public void goWest(){
        if (currentRoom.getWest() != null){
            currentRoom = currentRoom.getWest();
        }
        else {
            wrongWay();
        }
    }

    public void goSouth(){
        if (currentRoom.getSouth() != null){
            currentRoom = currentRoom.getSouth();
        }
        else {
            wrongWay();
        }
    }
}
