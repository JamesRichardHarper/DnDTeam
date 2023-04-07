package CharacterClasses;

import Innates.AbilityModifier;
import Innates.AbilityScore;

public class Actor {

    String Name;
    AbilityModifier activeStat;

    //Stats - Strength beats knowledge, knowledge beats willpower, willpower beats strength
    AbilityScore health;
    AbilityScore stamina;
    AbilityModifier strength;
    AbilityModifier knowledge;
    AbilityModifier willpower;

    public Actor(String name,
                 AbilityScore health,
                 AbilityScore stamina,
                 AbilityModifier strength,
                 AbilityModifier knowledge,
                 AbilityModifier willpower) {

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
        return "CharacterClasses.Actor Class \n " +
                "Name: " + getName() + "\n" +
                "Health: " + health.getBaseAbilityScore() + "\n" +
                "Stamina: " + stamina.getBaseAbilityScore() + "\n" +
                "Strength: " + strength.getBaseAbilityScore() + "(Score) + " + strength.getBaseAbilityModifier() + "(Mod) \n" +
                "Knowledge: " + knowledge.getBaseAbilityScore() + "(Score) + " + knowledge.getBaseAbilityModifier() + "(Mod) \n" +
                "Willpower: " + willpower.getBaseAbilityScore() + "(Score) + " + willpower.getBaseAbilityModifier() + "(Mod)";
    }
}
