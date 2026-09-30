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
        return player.getCurrentRoomItems();
    }

    public Item takeItem(String itemName)
    {
        return player.takeItem(itemName);
    }

    public Item dropItem(String itemName)
    {
        return player.dropItem(itemName);
    }

    public ArrayList<Item> getInventory()
    {
        return player.getInventory();
    }

    public int getHealth()
    {
        return player.getHealth();
    }

    // Sender eat-kommandoen videre fra UI til Player
    public EatOutcome eat (String itemName)
    {
        return player.eat(itemName);
    }

}