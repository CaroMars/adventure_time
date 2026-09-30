package Adventure_Time;

import java.util.ArrayList;

public class Player
{
    private Room currentRoom;

    private ArrayList<Item> inventory;

    private int health;

    public Player(Room startRoom)
    {
        currentRoom = startRoom;
        inventory = new ArrayList<>();
        health = 100;

    }
    public boolean move(String direction)
    {
        Room desiredRoom = switch (direction)
        {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "east" -> currentRoom.getEast();
            case "west" -> currentRoom.getWest();
            default -> null;
        };
        if (desiredRoom != null)
        {
            currentRoom = desiredRoom;
            return true;
        } else
        {
            return false;
        }
    }

    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    public String getCurrentRoomName()
    {
        return currentRoom.getName();
    }

    public String getCurrentRoomDescription()
    {
        return currentRoom.getDescription();
    }

    public ArrayList<Item> getCurrentRoomItems()
    {
        return currentRoom.getItems();
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public Item takeItem(String itemName)
    {
        for (Item item : currentRoom.getItems())
        {
            if (item.getShortName().equals(itemName))
            {
                currentRoom.getItems().remove(item);
                inventory.add(item);
                return item;
            }
        }

        return null;
    }


    public Item dropItem(String itemName)
    {
        for (Item item : inventory)
        {
            if (item.getShortName().equals(itemName))
            {
                inventory.remove(item);
                currentRoom.addItem(item);
                return item;
            }
        }

        return null;
    }

}
