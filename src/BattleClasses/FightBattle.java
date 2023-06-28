package BattleClasses;

import CharacterClasses.Actor;

import java.util.ArrayList;

public class FightBattle {

    Boolean fightOngoing = true;
    Actor playerOne;
    Actor playerTwo;
    ArrayList<Round> totalRounds = new ArrayList<>();

    public FightBattle(Actor playerOne, Actor playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Actor getPlayerOne() {
        return playerOne;
    }

    public Actor getPlayerTwo() {
        return playerTwo;
    }

    public Boolean getFightOngoing() {
        return fightOngoing;
    }

    public void setFightOngoing(Boolean fightOngoing) {
        this.fightOngoing = fightOngoing;
    }

    public ArrayList<Round> getTotalRounds() {
        return totalRounds;
    }

    public void setTotalRounds(ArrayList<Round> totalRounds) {
        this.totalRounds = totalRounds;
    }

    public void beginFight(){
        System.out.println(
                "Welcome to battle. \n" +
                "Today we have:\n" + getPlayerOne().getName() + " (" + getPlayerOne().getHealth().getModifiedAbilityScore() + ")\n" +
                        "VS. \n" +
                getPlayerTwo().getName() + " (" + getPlayerTwo().getHealth().getModifiedAbilityScore() + ")\n");

        while(getFightOngoing()){
            Round round = new Round(getPlayerOne(), getPlayerTwo());
            setFightOngoing(round.determineRoundResult(getPlayerOne(),getPlayerTwo()));

            getTotalRounds().add(round);

            System.out.println(
                    getPlayerOne().getName() + "(" + getPlayerOne().getHealth().getModifiedAbilityScore() + ") dealt " +
                    round.getPlayerOneBaseDamage() + "(x" + round.getPlayerOneMultiplier() + ") " + "\n" +
                            getPlayerTwo().getName() + "(" + getPlayerTwo().getHealth().getModifiedAbilityScore() + ") dealt " +
                    round.getPlayerTwoBaseDamage() + "(x" + round.getPlayerTwoMultiplier() + ")\n");

            if(getTotalRounds().size() > 20){
                setFightOngoing(false);
            }
        }
        //totalRounds.forEach( finishedRound -> System.out.println(finishedRound.toString()));
        System.out.println("Game Over");

    }
}
