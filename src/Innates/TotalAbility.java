package Innates;

public class TotalAbility extends AbilityModifier{
    String name;

    public TotalAbility(){
        super();
        this.name = "Unnamed";
    }

    public TotalAbility(int baseAbilityScore, String name) {
        super(baseAbilityScore);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
