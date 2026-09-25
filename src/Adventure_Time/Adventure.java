package Adventure_Time;

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
        return player.getCurrentRoom().getName();
    }

    public String getCurrentRoomDescription()
    {
        return player.getCurrentRoom().getDescription();
    }
}