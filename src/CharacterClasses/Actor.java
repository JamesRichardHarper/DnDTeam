package CharacterClasses;

import Innates.AbilityModifier;
import Innates.AbilityScore;
import Innates.Attribute;
import Innates.TotalAbility;

public class Actor {

    String Name;
    AbilityModifier activeStat;

    //Stats - Strength beats knowledge, knowledge beats willpower, willpower beats strength
    Attribute health;
    Attribute stamina;
    TotalAbility strength;
    TotalAbility knowledge;
    TotalAbility willpower;

    public Actor(String name,
                 Attribute health,
                 Attribute stamina,
                 TotalAbility strength,
                 TotalAbility knowledge,
                 TotalAbility willpower) {

        Name = name;
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
        this.knowledge = knowledge;
        this.willpower = willpower;
    }

    //Getters & Setters
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setActiveStat(AbilityModifier activeStat) {
        this.activeStat = activeStat;
    }

    //Attack Methods
    //Set attacking stat
    //Send Stat used
    public AbilityModifier attackPlayer(AbilityModifier statUsed){
        setActiveStat(statUsed);
        return statUsed;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Health: " + health.getBaseAbilityScore() + "(" + health.getRegenerate() + " per round) \n" +
                "Stamina: " + stamina.getBaseAbilityScore() + "(" + stamina.getRegenerate() + " per round) \n" +
                "Strength: " + strength.getBaseAbilityScore() + "(Score) + " + strength.getBaseAbilityModifier() + "(Mod) \n" +
                "Knowledge: " + knowledge.getBaseAbilityScore() + "(Score) + " + knowledge.getBaseAbilityModifier() + "(Mod) \n" +
                "Willpower: " + willpower.getBaseAbilityScore() + "(Score) + " + willpower.getBaseAbilityModifier() + "(Mod) \n";
    }
}
