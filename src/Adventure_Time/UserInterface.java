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
                adventure.goNorth();
                adventure.look();

            } else if (command.equals("go east"))
            {
                adventure.goEast();
                adventure.look();

            } else if (command.equals("go south"))
            {

                adventure.goSouth();
                adventure.look();

            } else if (command.equals("go west"))
            {

                adventure.goWest();
                adventure.look();

            } else if (command.equals("look"))
            {
                adventure.look();
            } else if (command.equals("help"))
            {
                System.out.println("instructions");
            }
            System.out.print("> ");
            command = scanner.nextLine();
        }
        System.out.println("exited the game");
    }
}
