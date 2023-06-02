package UI.ActualPages;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import UI.BulkText;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;
import UI.PageMethods;

public class CharacterPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[5];
    private String menu = "";
    private Actor activeCharacter;

    public CharacterPage(){
        this.pageActions[0] = new PageOption(1,"Random Stats - Random Name");
        this.pageActions[1] = new PageOption(2,"Random  Stats - Custom Name");
        this.pageActions[2] = new PageOption(3,"Custom Stats - Random Name");
        this.pageActions[3] = new PageOption(4,"Custom Stats - Custom Name");
        this.pageActions[4] = new PageOption(5,"Quit");

        this.menu = MenuFactory.makeMenu(
                "What kind of character do you want to make?",
                """
                        A completely random character will have all stats randomised, as well as having a random name.
                        A custom character will have the option of creating its' own stats, as well as having a personalised name.
                        """,
                pageActions);
    }

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
    public void runPage() {
        switch (chosenOption(Input.readInt())) {
            //Play
            case (1) -> {
                setActiveCharacter(ActorGeneration.createChar());
            }
            //Create Person
            case (2) -> {
                setActiveCharacter(ActorGeneration.createChar(BulkText.getVariableString("Name")));
            }

            //Settings
            case (3) -> {
                setActiveCharacter(PageMethods.createUserActor(ActorGeneration.getRandomName()));
            }

            //Exit
            case (9) -> {
                System.out.println("Goodbye!");
            }
        }
    }
}
