package BattleClasses;

import CharacterClasses.Actor;
import Innates.TotalAbility;

public class Round {
    String playerOneName;
    String playerTwoName;
    int playerOneDamage;
    int playerTwoDamage;
    Boolean playerOneAlive;
    Boolean playerTwoAlive;
    String playerOneAttack;
    String playerTwoAttack;
    double playerOneMultiplier;
    double playerTwoMultiplier;

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }

    public int getPlayerOneDamage() {
        return playerOneDamage;
    }

    public void setPlayerOneDamage(int playerOneDamage) {
        this.playerOneDamage = playerOneDamage;
    }

    public int getPlayerTwoDamage() {
        return playerTwoDamage;
    }

    public void setPlayerTwoDamage(int playerTwoDamage) {
        this.playerTwoDamage = playerTwoDamage;
    }

    public Boolean getPlayerOneAlive() {
        return playerOneAlive;
    }

    public void setPlayerOneAlive(Boolean playerOneAlive) {
        this.playerOneAlive = playerOneAlive;
    }

    public Boolean getPlayerTwoAlive() {
        return playerTwoAlive;
    }

    public void setPlayerTwoAlive(Boolean playerTwoAlive) {
        this.playerTwoAlive = playerTwoAlive;
    }

    public String getPlayerOneAttack() {
        return playerOneAttack;
    }

    public void setPlayerOneAttack(String playerOneAttack) {
        this.playerOneAttack = playerOneAttack;
    }

    public String getPlayerTwoAttack() {
        return playerTwoAttack;
    }

    public void setPlayerTwoAttack(String playerTwoAttack) {
        this.playerTwoAttack = playerTwoAttack;
    }

    public double getPlayerOneMultiplier() {
        return playerOneMultiplier;
    }

    public void setPlayerOneMultiplier(double playerOneMultiplier) {
        this.playerOneMultiplier = playerOneMultiplier;
    }

    public double getPlayerTwoMultiplier() {
        return playerTwoMultiplier;
    }

    public void setPlayerTwoMultiplier(double playerTwoMultiplier) {
        this.playerTwoMultiplier = playerTwoMultiplier;
    }

    public Boolean determineRoundResult(Actor playerOne, Actor playerTwo){
        setPlayerOneName(playerOne.getName());
        setPlayerTwoName(playerTwo.getName());

        TotalAbility playerOneAbility = playerOne.attackWithStat();
        TotalAbility playerTwoAbility = playerTwo.attackWithStat();

        setPlayerOneAttack(playerOneAbility.getName());
        setPlayerTwoAttack(playerTwoAbility.getName());

        //Compare the two and get damage to each other
        setPlayerOneMultiplier(getMultiplier(getPlayerOneAttack(), getPlayerTwoAttack()));
        setPlayerTwoMultiplier(getMultiplier(getPlayerTwoAttack(), getPlayerOneAttack()));

        setPlayerOneDamage((int) (getPlayerOneMultiplier()*playerOneAbility.getModifiedAbilityModifier()));
        setPlayerTwoDamage((int) (getPlayerTwoMultiplier()*playerTwoAbility.getModifiedAbilityModifier()));

        playerOne.takeDamage(getPlayerOneDamage());
        playerTwo.takeDamage(getPlayerTwoDamage());

        setPlayerOneAlive(playerOne.getAlive());
        setPlayerTwoAlive(playerTwo.getAlive());
        System.out.println(getPlayerOneAlive().toString() + " " + getPlayerTwoAlive().toString());
        System.out.println(playerOne.getHealth() + " " + playerTwo.getHealth());

        return playerNotDead(getPlayerOneAlive(), getPlayerTwoAlive());
    }

    public double getMultiplier(String attackedAbility, String attackerAbility){
        switch(attackerAbility){
            case "Strength":
                if(attackedAbility.equalsIgnoreCase("Knowledge")){
                    return 1.25;
                } else if (attackedAbility.equalsIgnoreCase("Wisdom")) {
                    return  0.75;
                }
                break;
            case "Knowledge":
                if(attackedAbility.equalsIgnoreCase("Wisdom")){
                    return 1.25;
                } else if (attackedAbility.equalsIgnoreCase("Strength")){
                    return  0.75;
                }
                break;
            case "Willpower":
                if(attackedAbility.equalsIgnoreCase("Strength")){
                    return 1.25;
                } else if (attackedAbility.equalsIgnoreCase("Knowledge")){
                    return  0.75;
                }
                break;
        }
        return 1.0;
    }

    public Boolean playerNotDead(Boolean playerOneAlive, Boolean playerTwoAlive){
        if (playerOneAlive) {
            if (playerTwoAlive){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return getPlayerOneName() + " (caused " + getPlayerOneDamage() + " " + getPlayerOneAttack() +
                " damage. \n" +
                getPlayerTwoName() + " caused " + getPlayerTwoDamage() + " " + getPlayerTwoAttack() +
                " damage.";
    }
}
