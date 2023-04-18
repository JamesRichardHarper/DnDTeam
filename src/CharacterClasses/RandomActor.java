package CharacterClasses;

import Innates.AbilityScore;
import Innates.Attribute;
import Innates.TotalAbility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomActor {

    Random random = new Random();

    public Actor createChar(){
        TotalAbility[] randomAbilities = bulkGenerateStats();
        return new
                Actor(getRandomName(),
                generateRandomAttribute("Health"),
                generateRandomAttribute("Stamina"),
                randomAbilities[0],
                randomAbilities[1],
                randomAbilities[2]);
    }

    public String getRandomName(){
        return Names.values()[random.nextInt(Names.values().length)].getName();
    }

    public Attribute generateRandomAttribute(String name){
        int capacitySmallBound = 10;
        int capacityLargeBound = 20;
        int regenSmallBound = 1;
        int regenLargeBound = 3;

        return new Attribute(
                random.nextInt(capacityLargeBound-capacitySmallBound) + capacitySmallBound,
                random.nextInt(regenLargeBound-regenSmallBound) + regenSmallBound,
                name);
    }

    public TotalAbility generateTotalAbility(String name){
        int[] skillRoles = new int[4];
        for (int index = 0; index <= (skillRoles.length - 1); index++) {
            skillRoles[index] = random.nextInt(6) + 1;
        }
        Arrays.sort(skillRoles);
        return new TotalAbility(skillRoles[1]+ skillRoles[2]+skillRoles[3], name);
    }

    public TotalAbility[] bulkGenerateStats(){

        String[] abilitiesNeeded = {"Strength", "Knowledge", "Willpower"};
        TotalAbility[] abilityList = new TotalAbility[3];
        int index = 0;

        for (String ability : abilitiesNeeded) {
            boolean positiveAbility = false;

            while(!positiveAbility){
                TotalAbility newAbility = generateTotalAbility(ability);
                if (newAbility.getModifiedAbilityModifier() > -1){
                    abilityList[index] = newAbility;
                    positiveAbility = true;
                    index++;
                }
            }
        }
        return abilityList;
    }
}
