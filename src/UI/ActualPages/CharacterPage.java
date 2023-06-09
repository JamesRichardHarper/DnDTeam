package UI.ActualPages;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Innates.Attribute;
import Innates.TotalAbility;
import Settings.WriteReadCharacter;
import UI.ActualPages.CommonPages.ConfirmationPage;
import UI.BulkText;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;
import UI.PageMethods;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CharacterPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[5];
    private String menu = "";
    private Actor activeCharacter;
    private Path saveLocation;

    public CharacterPage(Path saveLocation){
        this.saveLocation = saveLocation;
        this.pageActions[0] = new PageOption(1,"Random Stats - Random Name", () -> true);
        this.pageActions[1] = new PageOption(2,"Random  Stats - Custom Name", () -> true);
        this.pageActions[2] = new PageOption(3,"Custom Stats - Random Name", () -> true);
        this.pageActions[3] = new PageOption(4,"Custom Stats - Custom Name", () -> true);
        this.pageActions[4] = new PageOption(9,"Return", () -> true);

        this.menu = MenuFactory.makeMenu(
                "What kind of character do you want to make?",
                """
                        A completely random character will have all stats randomised, as well as having a random name.
                        A custom character will have the option of creating its' own stats, as well as having a personalised name.""",
                pageActions);
    }

    public Path getSaveLocation(){ return saveLocation;}

    public Actor getActiveCharacter() {
        return activeCharacter;
    }

    public void setActiveCharacter(Actor activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    @Override
    public PageOption[] getPageActions() {
        return pageActions;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public boolean runPage() {
        boolean isOn = true;

        System.out.println(getMenu());

        switch (chosenOption(Input.readInt())) {
            case (1) -> {
                setActiveCharacter(ActorGeneration.createChar());
            }
            case (2) -> {
                setActiveCharacter(
                        ActorGeneration.createChar(
                            Input.getVariableString("Name")
                    )
                );
            }
            case (3) -> {
                setActiveCharacter(ActorGeneration.createChar(
                        generateUserAttribute("Health"),
                        generateUserAttribute("Stamina"),
                        generateUserAbility("Strength"),
                        generateUserAbility("Knowledge"),
                        generateUserAbility("Willpower")

                    )
                );
            }
            case (4) -> {
                setActiveCharacter(
                        ActorGeneration.createChar(
                                Input.getVariableString("name"),
                                generateUserAttribute("Health"),
                                generateUserAttribute("Stamina"),
                                generateUserAbility("Strength"),
                                generateUserAbility("Knowledge"),
                                generateUserAbility("Willpower")
                        )
                );
            }
            case (9) -> {
                isOn = exit();
            }
        }

        if (getActiveCharacter()!=null){
            System.out.println(printGeneratedChar(getActiveCharacter().toString()));
            if (checkSave()){
                saveActor(getActiveCharacter(), getSaveLocation());
            }
        }

        return isOn;
    }

    public String printGeneratedChar(String charStats){
        return String.format("""
                Here is your character!
                -----------------------
                %s
                -----------------------""",
                charStats);
    }

    public void saveActor(Actor userChar, Path location){
        WriteReadCharacter.packActor(userChar, location);
    }

    public boolean checkSave(){
        ConfirmationPage confirmationPage = new ConfirmationPage("save character");
        return confirmationPage.runPage();
    }

    public Attribute generateUserAttribute(String name){
        return ActorGeneration.generateAttribute(
                Input.getVariableInt(String.format("%s capacity", name)),
                Input.getVariableInt(String.format("%s regen", name)),
                name);
    }

    public TotalAbility generateUserAbility(String name){
        return ActorGeneration.generateTotalAbility(
                name,
                Input.getVariableInt(String.format("%s score", name)));
    }

}
