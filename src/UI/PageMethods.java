package UI;

import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Innates.Attribute;
import Innates.TotalAbility;

public class PageMethods {
    public static boolean randomNameCheck(){
        BulkText.printRandomNamePage();
        int inputCharacter = Input.readInt();

        switch (inputCharacter) {
            //Random Name
            case (1) -> {
                return true;
            }

            //Own Name
            case (2) -> {
                return false;
            }

            default -> {
                return randomNameCheck();
            }
        }
    }

    public static boolean randomCharacterCheck(){
        BulkText.printCharacterPage();
        int inputCharacter = Input.readInt();

        switch (inputCharacter) {
            //Wants random character
            case (1) -> {
                return true;
            }

            //Wants a custom character
            case (2) -> {
                return false;
            }

            default -> {
                return randomCharacterCheck();
            }
        }
    }

    public static Attribute generateUserAttribute(String Name){
        return ActorGeneration.generateAttribute(
                BulkText.getVariableInt("$Name Capacity"),
                BulkText.getVariableInt("$Name Regeneration"),
                Name);
    }

    public static TotalAbility generateUserAbility(String Name){
        return ActorGeneration.generateTotalAbility(
                Name,
                BulkText.getVariableInt("$Name Score"));
    }

    public static Actor createUserActor() {
        return createUserActor(
                BulkText.getVariableString("Name")
        );
    }

    public static Actor createUserActor(String randomName) {
        return ActorGeneration.createChar(
                randomName,
                generateUserAttribute("Health"),
                generateUserAttribute("Stamina"),
                generateUserAbility("Strength"),
                generateUserAbility("Knowledge"),
                generateUserAbility("Willpower"));
    }
}
