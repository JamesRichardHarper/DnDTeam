package BattleClasses;

import CharacterClasses.Actor;
import CharacterInnates.TotalAbility;

public class Round {
    Actor playerOne;
    Actor playerTwo;
    int playerOneBaseDamage;
    int playerTwoBaseDamage;
    double playerOneMultiplier;
    double playerTwoMultiplier;

    boolean isAPlayerAlive = false;

    public Round(Actor playerOne, Actor playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Actor getPlayerOne() {
        return playerOne;
    }

    public Actor getPlayerTwo() {
        return playerTwo;
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

    public boolean getIsAPlayerAlive() {
        return isAPlayerAlive;
    }

    public void setPlayerOneBaseDamage(int playerOneBaseDamage) {
        this.playerOneBaseDamage = playerOneBaseDamage;
    }

    public void setPlayerTwoBaseDamage(int playerTwoBaseDamage) {
        this.playerTwoBaseDamage = playerTwoBaseDamage;
    }

    public void setPlayerOneMultiplier(double playerOneMultiplier) {
        this.playerOneMultiplier = playerOneMultiplier;
    }

    public void setPlayerTwoMultiplier(double playerTwoMultiplier) {
        this.playerTwoMultiplier = playerTwoMultiplier;
    }

    public void setAPlayerAlive(boolean APlayerAlive) {
        isAPlayerAlive = APlayerAlive;
    }

    //Used for two "AIs"
    public void calculateRound(){
        /*setPlayerOneBaseDamage(getPlayerOne().attackWithStat().getModifiedAbilityModifier());
        setPlayerTwoBaseDamage(getPlayerTwo().attackWithStat().getModifiedAbilityModifier());
        setPlayerOneMultiplier(calculateRelativeMultiplier(getPlayerTwo().getActiveStat().getName(), getPlayerOne().getActiveStat().getName()));
        setPlayerTwoMultiplier(calculateRelativeMultiplier(getPlayerOne().getActiveStat().getName(), getPlayerTwo().getActiveStat().getName()));
        setAPlayerDead(determineRoundResult(getPlayerOne(), getPlayerTwo()));*/

        calculateRound(getPlayerOne().returnRandomAbility().getName(),getPlayerTwo().returnRandomAbility().getName());
    }

    public void calculateRound(String humanStat){
        if(getPlayerOne().getPlayerControlled()){
            calculateRound(humanStat, getPlayerTwo().returnRandomAbility().getName());
        }
        else{
            calculateRound(getPlayerOne().returnRandomAbility().getName(), humanStat);
        }
    }

    //Used for two human Players
    public void calculateRound(String playerOneStat, String playerTwoStat){
        setPlayerOneBaseDamage(getPlayerOne().attackWithStat(
                getPlayerOne().getStatName(
                        playerOneStat)
                ).getModifiedAbilityModifier()
        );
        setPlayerTwoBaseDamage(
                getPlayerTwo().attackWithStat(
                        getPlayerTwo().getStatName(
                                playerTwoStat)
                ).getModifiedAbilityModifier()
        );
        setPlayerOneMultiplier(
                setPlayerMultiplier(getPlayerOne().getActiveStat(), getPlayerTwo().getActiveStat())
        );
        setPlayerTwoMultiplier(
                setPlayerMultiplier(getPlayerTwo().getActiveStat(), getPlayerTwo().getActiveStat())
        );
        setAPlayerAlive(determineRoundResult(getPlayerOne(), getPlayerTwo()));
    }

    public double setPlayerMultiplier(TotalAbility attackedAttribute, TotalAbility attackerAttribute){
        return calculateRelativeMultiplier(attackedAttribute.getName(), attackerAttribute.getName());
    }

    public Boolean determineRoundResult(Actor playerOne, Actor playerTwo){
        playerOne.takeDamage((int) (getPlayerTwoBaseDamage()*getPlayerTwoMultiplier()));
        playerTwo.takeDamage((int) (getPlayerOneBaseDamage()*getPlayerOneMultiplier()));
        return playerNotDead(playerOne.getAlive(), playerTwo.getAlive());
    }

    public double calculateRelativeMultiplier(String attackedAbility, String attackerAbility){
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
