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

    public TotalAbility getActiveStat() {
        return activeStat;
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

    public Attribute getHealth() {
        return this.health;
    }
    public void setHealth(Attribute health) {
        this.health = health;
    }

    public Attribute getStamina() {
        return this.stamina;
    }
    public void setStamina(Attribute stamina) {
        this.stamina = stamina;
    }

    public TotalAbility getStrength() {
        return strength;
    }
    public void setStrength(TotalAbility strength) {
        this.strength = strength;
    }

    public TotalAbility getKnowledge() {
        return knowledge;
    }
    public void setKnowledge(TotalAbility knowledge) {
        this.knowledge = knowledge;
    }

    public TotalAbility getWillpower() {
        return willpower;
    }
    public void setWillpower(TotalAbility willpower) {
        this.willpower = willpower;
    }

    //Attack Methods
    //Set attacking stat
    //Send Stat used
    public TotalAbility attackWithStat(TotalAbility statUsed){
        setActiveStat(statUsed);
        return statUsed;
    }

    public TotalAbility attackWithStat(){
        TotalAbility statUsed = returnRandomAbility();
        setActiveStat(statUsed);
        return statUsed;
    }

    public TotalAbility returnRandomAbility(){
        ArrayList<TotalAbility> abilityList = new ArrayList<>();
        if (getStrength().getModifiedAbilityModifier()>-1){
            abilityList.add(getStrength());
        }
        if (getKnowledge().getModifiedAbilityModifier()>-1){
            abilityList.add(getKnowledge());
        }
        if (getKnowledge().getModifiedAbilityModifier()>-1){
            abilityList.add(getWillpower());
        }
        int chance = random.nextInt(abilityList.size()-1);
        return abilityList.get(chance);
    }

    public void takeDamage(int damage){
        setAlive(
                /*health.modifyAbility(damage, false)*/
                getHealth().modifyAbility(damage, false)
        );
    }

    public void healDamage(int heal){
        getHealth().modifyAbility(heal, true);
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
