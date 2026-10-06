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

        // ROOM 1 - Cold stone entrance
        Item lamp = new Item("lamp", "A dusty old lamp");
        Item flashlight = new Item("flashlight", "A clean shiny flashlight");
        Food bread = new Food("bread", "A loaf of stale bread", 10);

        room1.addItem(lamp);
        room1.addItem(flashlight);
        room1.addItem(bread);


// ROOM 2 - Old dusty library
        Item book = new Item("book", "An ancient book covered in dust");
        Food potion = new Food("potion", "A mysterious red healing potion", 30);
        MeleeWeapon staff = new MeleeWeapon("staff", "An old wooden staff", 15);

        room2.addItem(book);
        room2.addItem(potion);
        room2.addItem(staff);


// ROOM 3 - Bloody dark room
        MeleeWeapon knife = new MeleeWeapon("knife", "A bloody old knife", 20);
        Food tastyMeat = new Food("meat", "A piece of tasty meat", 25);

        room3.addItem(knife);
        room3.addItem(tastyMeat);


// ROOM 4 - Damp mossy room
        Food mushroom = new Food("mushroom", "A pale glowing mushroom", -50);
        MeleeWeapon club = new MeleeWeapon("club", "A heavy wooden club covered in moss", 20);

        room4.addItem(mushroom);
        room4.addItem(club);


// ROOM 5 - Storage room
        Item rope = new Item("rope", "A long piece of old rope");
        Food apple = new Food("apple", "A surprisingly fresh apple", 15);
        MeleeWeapon sword = new MeleeWeapon("sword", "A rusty sword", 25);

        room5.addItem(rope);
        room5.addItem(apple);
        room5.addItem(sword);


// ROOM 6 - Fireplace room
        Food cookedMeat = new Food("cooked meat", "A warm piece of cooked meat", 25);
        MeleeWeapon axe = new MeleeWeapon("axe", "A heavy fire axe", 35);

        room6.addItem(cookedMeat);
        room6.addItem(axe);


// ROOM 7 - Ruined kitchen
        Food kitchenBread = new Food("loaf", "An old loaf left in the kitchen", 5);
        Food rottenApple = new Food("rotten apple", "A rotten apple that smells terrible", -20);
        MeleeWeapon kitchenFork = new MeleeWeapon("fork", "A sharp kitchen fork", 15);

        room7.addItem(kitchenBread);
        room7.addItem(rottenApple);
        room7.addItem(kitchenFork);


// ROOM 8 - Large statue hall
        Item amulet = new Item("amulet", "A golden amulet found near the stone statue");
        MeleeWeapon hammer = new MeleeWeapon("hammer", "A massive stone hammer", 40);

        room8.addItem(amulet);
        room8.addItem(hammer);


// ROOM 9 - Dark dungeon
        Item chains = new Item("chains", "A set of old rusty chains");
        RangedWeapon revolver = new RangedWeapon("revolver", "An old revolver", 40, 6);
        RangedWeapon crossbow = new RangedWeapon("crossbow", "An old wooden crossbow", 35, 4);
        Food poison = new Food("poison", "A bottle filled with poison", -75);

        room9.addItem(chains);
        room9.addItem(revolver);
        room9.addItem(crossbow);
        room9.addItem(poison);

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
