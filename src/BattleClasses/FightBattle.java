package BattleClasses;

import CharacterClasses.Actor;

import java.util.ArrayList;

public class FightBattle {

    Boolean fightOngoing = true;
    ArrayList<Round> totalRounds = new ArrayList<>();

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

    public void beginFight(Actor playerOne, Actor playerTwo){
        System.out.println(
                "Welcome to battle. \n" +
                "Today we have:\n" + playerOne.getName() + " (" + playerOne.getHealth() + ")\n" +
                        "VS. \n" +
                playerTwo.getName() + " (" + playerTwo.getHealth() + ")\n");

        while(fightOngoing){
            Round round = new Round(playerOne, playerTwo);
            setFightOngoing(round.determineRoundResult(playerOne,playerTwo));

            totalRounds.add(round);

            System.out.println(
                    playerOne.getName() + "(" + playerOne.getHealth() + ") dealt " +
                    round.getPlayerOneBaseDamage() + "(x" + round.getPlayerOneMultiplier() + ") " + "\n" +
                    playerTwo.getName() + "(" + playerTwo.getHealth() + ") dealt " +
                    round.getPlayerTwoBaseDamage() + "(x" + round.getPlayerTwoMultiplier() + ")\n");

            if(totalRounds.size() > 20){
                fightOngoing = false;
            }
        }
        //totalRounds.forEach( finishedRound -> System.out.println(finishedRound.toString()));
        System.out.println("Game Over");

    }
}
