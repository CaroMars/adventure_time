package Adventure_Time;

import java.util.ArrayList;

public class Adventure
{
    private Player player;
    private Map map;

    public Adventure()
    {
        map = new Map();
        player = new Player(map.getStartRoom());
    }

    public boolean go(String direction)
    {
        return player.move(direction);
    }

    public String getCurrentRoomName()
    {
        return player.getCurrentRoomName();
    }

    public String getCurrentRoomDescription()
    {
        return player.getCurrentRoomDescription();
    }

    public ArrayList<Item> getCurrentRoomItems()
    {
        return player.getCurrentRoom().getItems();
    }

    public boolean takeItem(Item item)
    {
        return player.takeItem(item);
    }

    public boolean dropItem(Item item)
    {
        return player.dropItem(item);
    }

    public ArrayList<Item> getInventory()
    {
        return player.getInventory();
    }

}