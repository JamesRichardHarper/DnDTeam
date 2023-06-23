package CharacterInnates;

public class TotalAbility extends AbilityModifier{
    String name;

    public TotalAbility(){
        super();
        this.name = "Unnamed Ability";
    }

    public TotalAbility(int baseAbilityScore, String name) {
        super(baseAbilityScore);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName){
        this.name = newName;
    }
}
