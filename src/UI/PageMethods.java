package UI;

import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Innates.Attribute;
import Innates.TotalAbility;
import Settings.WriteReadCharacter;

import java.nio.file.Path;

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

    public static boolean savingChar(Actor userChar){
        BulkText.printGeneratedChar(userChar.toString());
        int inputCharacter = Input.readInt();

        switch (inputCharacter) {
            //Save character
            case (1) -> {
                return true;
            }

            //Forget
            case (2) -> {
                return false;
            }

            default -> {
                return randomNameCheck();
            }
        }
    }

    public static Attribute generateUserAttribute(String name){
        return ActorGeneration.generateAttribute(
                BulkText.getVariableInt(String.format("%s capacity", name)),
                BulkText.getVariableInt(String.format("%s regen", name)),
                name);
    }

    public static TotalAbility generateUserAbility(String name){
        return ActorGeneration.generateTotalAbility(
                name,
                BulkText.getVariableInt(String.format("%s Score", name)));
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

    public static void saveActor(Actor userChar, Path location){
        WriteReadCharacter.packActor(userChar, location);
    }

}
