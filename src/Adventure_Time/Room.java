package Adventure_Time;

import java.util.ArrayList;

public class Room
{
    private String name;
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    public Room(String name, String description)
    {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void addEnemy(Enemy enemy)
    {
        enemies.add(enemy);
    }

    public ArrayList<Enemy> getEnemies()
    {
        return enemies;
    }

    public ArrayList<Item> getItems()
    {
        return items;
    }
    public void setNorth(Room north)
    {
        this.north = north;
    }

    public Room getNorth()
    {
        return north;
    }

    public void setEast(Room east)
    {
        this.east = east;
    }

    public Room getEast()
    {
        return east;
    }

    public void setSouth(Room south)
    {
        this.south = south;
    }

    public Room getSouth()
    {
        return south;
    }

    public void setWest(Room west)
    {
        this.west = west;
    }

    public Room getWest()
    {
        return west;
    }
}
