package Adventure_Time;

import java.util.ArrayList;

public class Player
{
    private Room currentRoom;

    private ArrayList<Item> inventory;

    public Player(Room startRoom)
    {
        currentRoom = startRoom;
        inventory = new ArrayList<>();

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

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public boolean takeItem(Item item)
    {
        if (currentRoom.getItems().contains(item))
        {
            currentRoom.getItems().remove(item);
            inventory.add(item);
            return true;

        }

        return false;
    }


    public boolean dropItem(Item item)
    {
        if (inventory.contains(item))
        {
            inventory.remove(item);
            currentRoom.addItem(item);
            return true;
        }

        return false;
    }

}
