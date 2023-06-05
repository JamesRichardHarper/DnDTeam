package CharacterClasses;

import Innates.Attribute;
import Innates.TotalAbility;

import java.util.Arrays;
import java.util.Random;

public class ActorGeneration {

    static Random random = new Random();

    //Completely Random Character
    public static Actor createChar(){
        return createChar(getRandomName());
    }

    //Random but with user Character name
    public static Actor createChar(String name){
        TotalAbility[] randomAbilities = bulkGenerateStats();
        return createChar(name,
                generateAttribute("Health"),
                generateAttribute("Stamina"),
                randomAbilities[0],
                randomAbilities[1],
                randomAbilities[2]);
    }

    //Custom character, random name
    public static Actor createChar(Attribute health,
                                   Attribute stamina,
                                   TotalAbility strength,
                                   TotalAbility knowledge,
                                   TotalAbility wisdom){
        return createChar(getRandomName(),
                health,
                stamina,
                strength,
                knowledge,
                wisdom);
    }

    //Base Create, fully customizable
    public static Actor createChar(String name,
                            Attribute health,
                            Attribute stamina,
                            TotalAbility strength,
                            TotalAbility knowledge,
                            TotalAbility wisdom){
        return new Actor(name,
                health,
                stamina,
                strength,
                knowledge,
                wisdom);
    }

    public static String getRandomName(){
        return Names.values()[random.nextInt(Names.values().length)].getName();
    }

    public static Attribute generateAttribute(int capacity, int regenAmount, String name){
        return new Attribute(capacity, regenAmount, name);
    }

    public static Attribute generateAttribute(String name){
        int capacitySmallBound = 10;
        int capacityLargeBound = 20;
        int regenSmallBound = 1;
        int regenLargeBound = 3;

        return generateAttribute(
                random.nextInt(capacityLargeBound-capacitySmallBound) + capacitySmallBound,
                random.nextInt(regenLargeBound-regenSmallBound) + regenSmallBound,
                name);
    }

    public static TotalAbility generateTotalAbility(String name, int totalScore){
        return new TotalAbility(totalScore, name);
    }

    public static TotalAbility generateTotalAbility(String name){
        int[] skillRoles = new int[3];
        for (int index = 0; index <= (skillRoles.length - 1); index++) {
            skillRoles[index] = random.nextInt(6) + 1;
        }
        Arrays.sort(skillRoles);
        return new TotalAbility(
                skillRoles[0] +
                             skillRoles[1] +
                             skillRoles[2],
                name);
    }

    public static TotalAbility[] bulkGenerateStats(){

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
