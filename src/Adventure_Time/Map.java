package Adventure_Time;

public class Map
{
    private Room startRoom;

    public Map()
    {
        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "A room with no distinct features, except two doors.");
        Room room3 = new Room("Room 3", "A room with no distinct features, except two doors.");
        Room room4 = new Room("Room 4", "A room with no distinct features, except two doors.");
        Room room5 = new Room("Room 5", "A room with no distinct features, except one door.");
        Room room6 = new Room("Room 6", "A room with no distinct features, except two doors.");
        Room room7 = new Room("Room 7", "A room with no distinct features, except two doors.");
        Room room8 = new Room("Room 8", "A room with no distinct features, except three doors.");
        Room room9 = new Room("Room 9", "A room with no distinct features, except two doors.");

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

        startRoom = room1;
    }

    public Room getStartRoom()
    {
        return startRoom;
    }
}
