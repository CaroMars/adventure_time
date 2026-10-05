package Adventure_Time;

public class AttackOutcome
{

    private final AttackResult result;
    private final String weaponName;
    private final String attackVerb;
    private final String usesLeftText;

    public AttackOutcome(AttackResult result, String weaponName,
                         String attackVerb, String usesLeftText)
    {
        this.result = result;
        this.weaponName = weaponName;
        this.attackVerb = attackVerb;
        this.usesLeftText = usesLeftText;
    }

    public AttackResult getResult()
    {
        return result;
    }

    public String getWeaponName()
    {
        return weaponName;
    }

    public String getAttackVerb()
    {
        return attackVerb;
    }

    public String getUsesLeftText()
    {
        return usesLeftText;
    }
}