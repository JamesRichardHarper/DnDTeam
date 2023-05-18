package UI;

import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Innates.Attribute;

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
        BulkText.printRandomNamePage();
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

    public static String getVariableName(String variableNeeded){
        BulkText.printCustomVariable(variableNeeded);
        return Input.readString();
    }

    public static int getVariableInt(String variableNeeded){
        BulkText.printCustomVariable(variableNeeded);
        return Input.readInt();
    }

    public static Attribute generateUserAttribute(String Name){
        return
    }

    public static Actor createCustomActor() {
        ActorGeneration needAnActor = new ActorGeneration();
        return needAnActor.createChar(
                PageMethods.getVariableName("Name"),
                needAnActor.generateAttribute(
                        getVariableInt("Health Pool"),
                        getVariableInt("Health Regeneration"),
                        "Health"),
                needAnActor.generateAttribute(
                        getVariableInt("Stamina Pool"),
                        getVariableInt("Stamina Regeneration"),
                        getVariableName("Stamina")),
                needAnActor.generateTotalAbility(
                        "Strength",
                        getVariableInt("Strength")
                ),
                getVariableInt("Knowledge"),
                getVariableInt("Willpower"));
    }
}
