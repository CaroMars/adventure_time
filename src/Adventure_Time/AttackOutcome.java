package Adventure_Time;

public class AttackOutcome
{
    private final AttackResult result;
    private final String weaponName;
    private final String attackVerb;
    private final String usesLeftText;

    private final String enemyName;
    private final int enemyHealth;
    private final boolean enemyDead;
    private final int damageTaken;

    public AttackOutcome(AttackResult result, String weaponName,
                         String attackVerb, String usesLeftText,
                         String enemyName, int enemyHealth,
                         boolean enemyDead, int damageTaken)
    {
        this.result = result;
        this.weaponName = weaponName;
        this.attackVerb = attackVerb;
        this.usesLeftText = usesLeftText;
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyDead = enemyDead;
        this.damageTaken = damageTaken;
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

    public String getEnemyName()
    {
        return enemyName;
    }

    public int getEnemyHealth()
    {
        return enemyHealth;
    }

    public boolean isEnemyDead()
    {
        return enemyDead;
    }

    public int getDamageTaken()
    {
        return damageTaken;
    }
}