package Items;

public class fightingTape extends BaseItem{

    String name = "Fighting Tape";
    String description = "";

    public fightingTape(String damageType, int diceDamage, int minimumDamage, boolean inverse) {
        super(damageType, diceDamage, minimumDamage, inverse);
    }
}
