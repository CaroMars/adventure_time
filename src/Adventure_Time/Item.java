package Adventure_Time;

public class Item
{
    private String shortName;
    //korte navn bruges til kommandoer som "get lamp"
    private String longName;
    //lange navn bruges til description af item når man træder ind i rum.

    public Item(String shortName, String longName)
    {
        this.shortName = shortName;
        this.longName = longName;
    }


    public String getShortName()
    {
        return shortName;
    }

    public String getLongName()
    {
        return longName;
    }

}
