public class Item
{
    private String shortName;
    private String longName;

    public Item (String shortName, String longName){
        this.shortName = shortName;
        this.longName = longName;
    }

    // shortName bruges når spilleren skriver navnet på item'et

    public String getShortName()
    {
        return shortName;
    }

    // longName er den længere beskrivelse af item'et


    public String getLongName()
    {
        return longName;
    }
}
