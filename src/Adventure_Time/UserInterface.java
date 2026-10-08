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
            }
            else if (command.equals("go south"))
            {
                go("south");
            }
            else if (command.equals("go east"))
            {
                go("east");
            }
            else if (command.equals("go west"))
            {
                go("west");
            }
            else if (command.equals("look"))
            {
                look();
            }

            else if (command.equals("map"))
            {
                map();
            }

            else if (command.equals("inventory"))
            {
                inventory();
            }
            else if (command.startsWith("take "))
            {
                take(command.substring(5));
            }
            else if (command.startsWith("drop "))
            {
                drop(command.substring(5));
            } else if (command.startsWith("eat "))
            {
                eat(command.substring(4));
            } else if (command.startsWith("equip ")){
                equip(command.substring(6));

            } else if (command.startsWith("attack "))
            {
                attack(command.substring(7));
            }




             else if (command.equals("health"))
            {
                int health = adventure.getHealth();

                if (health >= 100)
                {
                    System.out.println("health: " + health + " - you are in perfect health");
                }
                else if (health >= 50)
                {
                    System.out.println("health: " + health + " - you are in good health, but avoid fighting right now");
                }
                else if (health >= 25)
                {
                    System.out.println("health: " + health + " - you are wounded - find something healthy to eat");
                }
                else if (health >= 1)
                {
                    System.out.println("health: " + health + " - you are barely alive");
                }
                else
                {
                    System.out.println("health: " + health + " - you should be dead");
                }
            }
            else if (command.equals("help"))
            {
                System.out.println("=== MOVEMENT ===");

                for (String direction : adventure.getAvailableDirections())
                {
                    System.out.println("go " + direction);
                }

                System.out.println(
                        "\n" +
                                "=== INFORMATION ===\n" +
                                "look\n" +
                                "map\n" +
                                "health\n" +
                                "inventory\n" +
                                "\n" +
                                "=== ITEMS ===\n" +
                                "take <item>\n" +
                                "drop <item>\n" +
                                "eat <item>\n" +
                                "equip <weapon>\n" +
                                "\n" +
                                "=== COMBAT ===\n" +
                                "attack <enemy>\n" +
                                "\n" +
                                "=== GAME ===\n" +
                                "exit"
                );
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

        for (Item item : adventure.getCurrentRoomItems())
        {
            System.out.println(item.getLongName());
        }

        for (Enemy enemy : adventure.getCurrentRoomEnemies())
        {
            System.out.println(enemy.getDescription());
        }
    }

    private void map()
    {
        String currentRoom = adventure.getCurrentRoomName();

        String room1 = currentRoom.equals("Room 1") ? "Room 1 *" : "Room 1";
        String room2 = currentRoom.equals("Room 2") ? "Room 2 *" : "Room 2";
        String room3 = currentRoom.equals("Room 3") ? "Room 3 *" : "Room 3";
        String room4 = currentRoom.equals("Room 4") ? "Room 4 *" : "Room 4";
        String room5 = currentRoom.equals("Room 5") ? "Room 5 *" : "Room 5";
        String room6 = currentRoom.equals("Room 6") ? "Room 6 *" : "Room 6";
        String room7 = currentRoom.equals("Room 7") ? "Room 7 *" : "Room 7";
        String room8 = currentRoom.equals("Room 8") ? "Room 8 *" : "Room 8";
        String room9 = currentRoom.equals("Room 9") ? "Room 9 *" : "Room 9";

        System.out.printf(
                "+----------+     +----------+     +----------+%n" +
                        "| %-8s |-----| %-8s |-----| %-8s |%n" +
                        "+----------+     +----------+     +----------+%n" +
                        "     |                                  |%n" +
                        "     |                                  |%n" +
                        "+----------+     +----------+     +----------+%n" +
                        "| %-8s |     | %-8s |     | %-8s |%n" +
                        "+----------+     +----------+     +----------+%n" +
                        "     |                |                 |%n" +
                        "     |                |                 |%n" +
                        "+----------+     +----------+     +----------+%n" +
                        "| %-8s |-----| %-8s |-----| %-8s |%n" +
                        "+----------+     +----------+     +----------+%n" +
                        "* = YOU%n",
                room1, room2, room3,
                room4, room5, room6,
                room7, room8, room9
        );
    }

    private void inventory()
    {
        for (Item item : adventure.getInventory())
        {
            System.out.println(item.getLongName());

        }
        Weapon equipped = adventure.getEquipped();

        if (equipped != null)
        {
            System.out.println("Equipped: " + equipped.getLongName());
        }

    }

    private void take(String itemName)
    {
        Item item = adventure.takeItem(itemName);

        if (item != null)
        {
            System.out.println("You took " + item.getShortName());
        }
        else
        {
            System.out.println("There is no " + itemName + " here.");
        }
    }

    private void drop(String itemName)
    {
        Item item = adventure.dropItem(itemName);

        if (item != null)
        {
            System.out.println("You dropped " + item.getShortName());
        }
        else
        {
            System.out.println("You don't have " + itemName + ".");
        }
    }

    // EAT UI - Viser resultat af eat kommandoen til spilleren
    private void eat (String itemName)
    {
        EatOutcome outcome = adventure.eat(itemName);

        switch (outcome.getResult())
        {
            case NOT_FOUND:
                System.out.println("There is nothing like " + itemName + " to eat around here");
                break;

            case NOT_FOOD:
                System.out.println("You cannot eat " + outcome.getItemName());
                break;

            case EATEN:
                if (outcome.getHealthChange()< 0)
                {
                    System.out.println("You eat " + outcome.getItemName() + ". That was a mistake.");
                }
                else
                {
                    System.out.println("You eat " + outcome.getItemName() + ". You feel a litle better.");
                    break;
                }

        }
    }
    private void equip(String shortname)
    {
        EquipOutcome outcome = adventure.equip(shortname);

        switch (outcome.getResult())
        {
            case NOT_FOUND:
                System.out.println("You do not have a weapon called " + shortname);
                break;

            case NOT_WEAPON:
                System.out.println(outcome.getItemName() + " is not a weapon");
                break;

            case EQUIPPED:
                System.out.println("You have equipped " + outcome.getItemName());
                break;
        }
    }
    private void attack(String enemyName)
    {
        AttackOutcome outcome = adventure.attack(enemyName);

        switch (outcome.getResult())
        {
            case NO_ENEMY:
                System.out.println("There is no " + enemyName + " here.");
                break;

            case NO_WEAPON:
                System.out.println("You do not have a weapon equipped.");
                break;

            case NO_USES_LEFT:
                System.out.println("You cannot use " + outcome.getWeaponName()
                        + ". It has no uses left.");
                break;

            case ATTACKED:
                System.out.println("You " + outcome.getAttackVerb()
                        + " " + outcome.getEnemyName()
                        + " with " + outcome.getWeaponName() + ".");

                if (outcome.isEnemyDead())
                {
                    System.out.println(outcome.getEnemyName() + " is dead.");
                    System.out.println("The enemy dropped its weapon.");
                }
                else
                {
                    System.out.println(outcome.getEnemyName()
                            + " has " + outcome.getEnemyHealth()
                            + " health left.");

                    System.out.println(outcome.getEnemyName()
                            + " attacks you back for "
                            + outcome.getDamageTaken()
                            + " damage.");

                    System.out.println("Your health: " + adventure.getHealth());
                }

                System.out.println(outcome.getUsesLeftText());
                break;
        }
    }

    }

