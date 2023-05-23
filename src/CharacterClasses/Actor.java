package CharacterClasses;

import Innates.Attribute;
import Innates.TotalAbility;

import java.util.ArrayList;
import java.util.Random;

public class Actor {
    Random random = new Random();

    //Innates
    Boolean alive;
    Boolean playerControlled;
    String name;
    TotalAbility activeStat;

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
        alive = true;
        playerControlled = false;
        this.name = name;
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
        this.knowledge = knowledge;
        this.willpower = willpower;
    }

    //Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setActiveStat(TotalAbility activeStat) {
        this.activeStat = activeStat;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    public Boolean getPlayerControlled() {
        return playerControlled;
    }
    public void setPlayerControlled(Boolean playerControlled) {
        this.playerControlled = playerControlled;
    }
    public TotalAbility getActiveStat() {
        return activeStat;
    }
    public int getHealth() {
        return health.getModifiedAbilityScore();
    }
    public int getStamina() {
        return stamina.getModifiedAbilityScore();
    }

    //Attack Methods
    //Set attacking stat
    //Send Stat used
    public TotalAbility attackWithStat(TotalAbility statUsed){
        setActiveStat(statUsed);
        return statUsed;
    }

    public TotalAbility attackWithStat(){
        TotalAbility statUsed = getRandomAbility();
        setActiveStat(statUsed);
        return statUsed;
    }

    public TotalAbility getRandomAbility(){
        ArrayList<TotalAbility> abilityList = new ArrayList<>();
        if (strength.getModifiedAbilityModifier()>-1){
            abilityList.add(strength);
        }
        if (strength.getModifiedAbilityModifier()>-1){
            abilityList.add(knowledge);
        }
        if (strength.getModifiedAbilityModifier()>-1){
            abilityList.add(willpower);
        }
        int chance = random.nextInt(abilityList.size()-1);
        return abilityList.get(chance);
    }

    public void takeDamage(int damage){
        setAlive(health.modifyAbility(damage, false));
    }

    public void healDamage(int heal){
        health.modifyAbility(heal, true);
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
