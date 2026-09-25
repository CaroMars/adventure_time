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
            } else if (command.equals("help"))
            {
                System.out.println("instructions");
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
}
