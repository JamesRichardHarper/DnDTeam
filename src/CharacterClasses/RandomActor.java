package CharacterClasses;

import Innates.AbilityScore;
import Innates.Attribute;
import Innates.TotalAbility;

import java.util.ArrayList;
import java.util.Random;

public class RandomActor {

    Random random = new Random();

    public Actor createChar(){
        Actor newActor = new
                Actor(getRandomName(),
                generateRandomAttribute("Health"),
                generateRandomAttribute("Stamina"),
                generateTotalAbility("Strength"),
                generateTotalAbility("Knowledge"),
                generateTotalAbility("Willpower"));

        return newActor;
    }

    public String getRandomName(){
        String nameRandom = Names.values()[random.nextInt(Names.values().length)].getName();
        return nameRandom;
    }

    public Attribute generateRandomAttribute(String name){
        int capacitySmallBound = 10;
        int capacityLargeBound = 20;
        int regenSmallBound = 1;
        int regenLargeBound = 3;

        Attribute attribute = new Attribute(
                random.nextInt(capacityLargeBound-capacitySmallBound) + capacitySmallBound,
                random.nextInt(regenLargeBound-regenSmallBound) + regenSmallBound,
                name);

        return attribute;
    }

    public TotalAbility generateTotalAbility(String name){
        int skillRole =
                random.nextInt(7) +
                random.nextInt(7) +
                random.nextInt(7);

        TotalAbility newAbility = new TotalAbility(skillRole, name);

        return newAbility;
    }
}
