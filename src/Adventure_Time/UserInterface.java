package Adventure_Time;

import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner;
    private Adventure adventure;

    public UserInterface(Adventure adventure)
    {
        scanner = new Scanner(System.in);
        this.adventure = adventure;
    }

    public void getCommand()
    {
        System.out.print("> ");
        String command = scanner.nextLine();
        while (!command.equals("exit"))
        {
            if (command.equals("go north"))
            {
                go("north");
            } else if (command.equals("go south"))
            {
                go("south");
            } else if (command.equals("go east"))
            {
                go("east");
            } else if (command.equals("go west"))
            {
                go("west");
            } else if (command.equals("look"))
            {
                look();
            } else if (command.equals("inventory"))
            {
                inventory();
            } else if (command.startsWith("take "))
            {
                take(command.substring(5));
            } else if (command.startsWith("drop "))
            {
                drop(command.substring(5));
            } else if (command.equals("help"))
            {
                System.out.println("go north\n" +
                        "go south\n" +
                        "go east\n" +
                        "go west\n" +
                        "look\n" +
                        "inventory\n" +
                        "take <item>\n" +
                        "drop <item>\n" +
                        "help\n" +
                        "exit");
            }
            System.out.print("> ");
            command = scanner.nextLine();
        }
        System.out.println("exited the game");
    }

    private void go(String direction)
    {
        boolean moved = adventure.go(direction);

        if (moved)
        {
            look();
        } else
        {
            System.out.println("you can't go that way");
        }
    }

    private void look()
    {
        System.out.println(adventure.getCurrentRoomName());
        System.out.println(adventure.getCurrentRoomDescription());
    }

    private void inventory()
    {
        for (Item item : adventure.getInventory())
        {
            System.out.println(item.getLongName());
        }
    }

    private void take(String itemName)
    {
        for (Item item : adventure.getCurrentRoomItems())
        {
            if (item.getShortName().equals(itemName))
            {
                adventure.takeItem(item);
                System.out.println("You took " + item.getShortName());
                return;
            }
        }
        System.out.println("There is no " + itemName + " here.");
    }

    private void drop(String itemName)
    {
        for (Item item : adventure.getInventory())
        {
            if (item.getShortName().equals(itemName))
            {
                adventure.dropItem(item);
                System.out.println("You dropped " + item.getShortName());
                return;
            }
        }
        System.out.println("You don't have " + itemName + ".");
    }
}
