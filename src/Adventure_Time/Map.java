package Adventure_Time;

public class Map
{
    private Room startRoom;

    public Map()
    {
        buildMap();
    }

    private void buildMap()
    {
        Room room1 = new Room("Room 1", "A cold stone room with two doors.");
        Room room2 = new Room("Room 2", "An old library covered in dust, with two doors.");
        Room room3 = new Room("Room 3", "A dark room with blood on the floor and two doors.");
        Room room4 = new Room("Room 4", "A damp room covered in green moss, with two doors.");
        Room room5 = new Room("Room 5", "A small storage room with broken crates and one door.");
        Room room6 = new Room("Room 6", "A warm room lit by a fireplace, with two doors.");
        Room room7 = new Room("Room 7", "A ruined kitchen with rotten food and two doors.");
        Room room8 = new Room("Room 8", "A large hall with an old stone statue and three doors.");
        Room room9 = new Room("Room 9", "A dark dungeon with chains on the walls and two doors.");

        Item lamp = new Item("lamp", "A dusty old lamp");
        Item flashlight = new Item("flashlight", "A clean shiny flashlight");
        Food bread = new Food("bread", "A loaf of stale bread", 10);
        Food mushroom = new Food("mushroom","a pale glowing mushroom",-50 );
        MeleeWeapon sword = new MeleeWeapon("sword", "a rusty sword", 25);
        RangedWeapon revolver = new RangedWeapon("revolver", "an old revolver", 40, 6);


        room1.addItem(lamp);
        room1.addItem(flashlight);
        room1.addItem(bread);
        room1.addItem(mushroom);
        room1.addItem(sword);
        room1.addItem(revolver);

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
