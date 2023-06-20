package BattleClasses;

import CharacterClasses.Actor;

public class Round {
    Actor playerOne;
    Actor playerTwo;
    int playerOneBaseDamage;
    int playerTwoBaseDamage;
    double playerOneMultiplier;
    double playerTwoMultiplier;

    public Round(Actor playerOne, Actor playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;

        //playerOne.attackWithStat();
        //playerTwo.attackWithStat();

        this.playerOneBaseDamage = playerOne.attackWithStat().getModifiedAbilityModifier();
        this.playerTwoBaseDamage = playerTwo.attackWithStat().getModifiedAbilityModifier();
        this.playerOneMultiplier = getMultiplier(playerTwo.getActiveStat().getName(), playerOne.getActiveStat().getName());
        this.playerTwoMultiplier = getMultiplier(playerOne.getActiveStat().getName(), playerTwo.getActiveStat().getName());
    }

    public int getPlayerOneBaseDamage() {
        return playerOneBaseDamage;
    }

    public int getPlayerTwoBaseDamage() {
        return playerTwoBaseDamage;
    }

    public double getPlayerOneMultiplier() {
        return playerOneMultiplier;
    }

    public double getPlayerTwoMultiplier() {
        return playerTwoMultiplier;
    }

    public Boolean determineRoundResult(Actor playerOne, Actor playerTwo){
        playerOne.takeDamage((int) (getPlayerTwoBaseDamage()*getPlayerTwoMultiplier()));
        playerTwo.takeDamage((int) (getPlayerOneBaseDamage()*getPlayerOneMultiplier()));
        return playerNotDead(playerOne.getAlive(), playerTwo.getAlive());
    }

    public double getMultiplier(String attackedAbility, String attackerAbility){
        double effectiveAttack = 1.5;
        double ineffectiveAttack = 0.5;

        switch(attackerAbility){
            case "Strength":
                if(attackedAbility.equalsIgnoreCase("Knowledge")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Wisdom")) {
                    return  ineffectiveAttack;
                }
                break;
            case "Knowledge":
                if(attackedAbility.equalsIgnoreCase("Wisdom")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Strength")){
                    return  ineffectiveAttack;
                }
                break;
            case "Willpower":
                if(attackedAbility.equalsIgnoreCase("Strength")){
                    return effectiveAttack;
                } else if (attackedAbility.equalsIgnoreCase("Knowledge")){
                    return  ineffectiveAttack;
                }
                break;
        }
        return 1.0;
    }

    public Boolean playerNotDead(Boolean playerOneAlive, Boolean playerTwoAlive){
        if (playerOneAlive) {
            return playerTwoAlive;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "A 'round' Object (lol) containing the details of " +
                playerOne.getName() + " and " + playerTwo.getName();
    }
}
