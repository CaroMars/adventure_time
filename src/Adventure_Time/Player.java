package Adventure_Time;

import java.util.ArrayList;

public class Player
{
    private Room currentRoom;

    private ArrayList<Item> inventory;

    private int health;

    private Weapon equipped;

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

    public ArrayList<Enemy> getCurrentRoomEnemies()
    {
        return currentRoom.getEnemies();
    }

    public ArrayList<String> getAvailableDirections()
    {
        ArrayList<String> directions = new ArrayList<>();

        if (currentRoom.getNorth() != null)
        {
            directions.add("north");
        }

        if (currentRoom.getSouth() != null)
        {
            directions.add("south");
        }

        if (currentRoom.getEast() != null)
        {
            directions.add("east");
        }

        if (currentRoom.getWest() != null)
        {
            directions.add("west");
        }

        return directions;
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
                if (item == equipped)
                {
                    equipped = null;
                }
                inventory.remove(item);
                currentRoom.addItem(item);
                return item;
            }
        }

        return null;
    }

    public int getHealth()
    {
        return health;
    }

    // Finder mad i inventory/rummet, ændre health og fjerne maden
    public EatOutcome eat(String itemName)
    {
        Item foundItem = null;
        boolean inInventory = false;

        //leder vi efter i spillerens inventory
        for (Item item : inventory)
        {
            if (item.getShortName().equalsIgnoreCase(itemName))
            {
                foundItem = item;
                inInventory = true;
                break;
            }
        }

        //Hvis den ikke blev fundet i inventory, leder vi i rummet

        if (foundItem == null)
        {
            for (Item item : currentRoom.getItems())
            {
                if (item.getShortName().equalsIgnoreCase(itemName))
                {
                    foundItem = item;
                    break;
                }
            }
        }

        // Tingen findes ikke
        if (foundItem == null)
        {
            return new EatOutcome(EatResult.NOT_FOUND, null, 0);

        }

        // Tingen findes men ikke er mad
        if (!(foundItem instanceof Food))
        {
            return new EatOutcome(EatResult.NOT_FOOD, foundItem.getLongName(), 0);

        }

        // Tingen er food
        Food food = (Food) foundItem;

        int healthChange = food.getHealthPoints();
        health += healthChange;

        //Fjern maden efter den er blevet spist
        if (inInventory)
        {
            inventory.remove(foundItem);
        }
        else
        {
            currentRoom.getItems().remove(foundItem);
        }
        return new EatOutcome(EatResult.EATEN, foundItem.getLongName(), healthChange);



    }

    public EquipOutcome equip (String shortName){
        Item foundItem = null;

        for (Item item : inventory){
            if (item.getShortName().equalsIgnoreCase(shortName)){
                foundItem = item;
                break;
            }
        }
        if (foundItem == null){
            return new EquipOutcome(EquipResult.NOT_FOUND, null);
        }
        if (!(foundItem instanceof Weapon)){
            return new EquipOutcome(EquipResult.NOT_WEAPON, foundItem.getLongName());
        }


        equipped = (Weapon) foundItem;
        return new EquipOutcome(EquipResult.EQUIPPED, foundItem.getLongName());
    }


    public Weapon GetEqquiped(){
        return equipped;
    }

    public AttackOutcome attack(String enemyName)
    {
        Enemy target = null;

        for (Enemy enemy : currentRoom.getEnemies())
        {
            if (enemy.getName().equalsIgnoreCase(enemyName))
            {
                target = enemy;
                break;
            }
        }

        if (target == null)
        {
            return new AttackOutcome(
                    AttackResult.NO_ENEMY,
                    null,
                    null,
                    null
            );
        }
        if (equipped == null)
        {
            return new AttackOutcome(
                    AttackResult.NO_WEAPON,
                    null,
                    null,
                    null);

        }
        if (!equipped.canUse())
        {
            return new AttackOutcome(
                    AttackResult.NO_USES_LEFT,
                    equipped.getLongName(),
                    equipped.getAttackVerb(),
                    equipped.getUsesLeftText()
            );
        }

        equipped.use();

        return new AttackOutcome(
                AttackResult.ATTACKED,
                equipped.getLongName(),
                equipped.getAttackVerb(),
                equipped.getUsesLeftText()
        );

    }


}

