package Adventure_Time;

public class EquipOutcome
{
    private final EquipResult result;
    private final String itemName;

    public EquipOutcome(EquipResult result, String itemName){
        this.result = result;
        this.itemName = itemName;
    }

    public EquipResult getResult(){
        return result;
    }

    public String getItemName(){
        return itemName;
    }

}
