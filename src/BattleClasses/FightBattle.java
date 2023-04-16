package BattleClasses;

import CharacterClasses.Actor;

import java.util.ArrayList;

public class FightBattle {

    Boolean fightOngoing = true;
    ArrayList<Round> totalRounds = new ArrayList<>();

    public void beginFight(Actor playerOne, Actor playerTwo){
        System.out.println(
                "Welcome to battle. \n" +
                "Today we have " + playerOne.getName() + " VS. " + playerTwo.getName());
        while(fightOngoing){
            Round round = new Round();
            fightOngoing = round.determineRoundResult(playerOne,playerTwo);
            totalRounds.add(round);
            if(totalRounds.size() > 10){
                fightOngoing = false;
            }
        }
        totalRounds.forEach( finishedRound -> System.out.println(finishedRound.toString()));
        System.out.println("Game Over");

    }
}
