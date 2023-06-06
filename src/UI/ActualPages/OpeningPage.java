package UI.ActualPages;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Settings.Options;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class OpeningPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[4];
    private String menu = "";
    private Options settings = new Options();
    public CharacterPage characterPage = new CharacterPage(Paths.get(getSettings().getSetting("Save_Location")));
    //public Function<CharacterPage, Boolean> action = CharacterPage::runPage;

    public OpeningPage(){
        this.pageActions[0] = new PageOption(1,"Play", () -> true);
        /*this.pageActions[1] = new PageOption(2,"Create Random Character", () -> characterPage.runPage());*/
        this.pageActions[1] = new PageOption(2,"Create Random Character", () -> characterPage.runPage());
        this.pageActions[2] = new PageOption(8,"Settings", () -> true);
        this.pageActions[3] = new PageOption(9,"Quit", () -> true);

        this.menu = MenuFactory.makeMenu(
                "Welcome!",
                "What is it you would like to do?",
                pageActions);
    }

    public Options getSettings(){return settings;}

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
        boolean runPage = true;

        System.out.println(getMenu());

        switch (chosenOption(Input.readInt())) {
            //Play
            case (1) -> {
                FightBattle need2fite = new FightBattle();
                Actor randomPersonOne = ActorGeneration.createChar();
                Actor randomPersonTwo = ActorGeneration.createChar();
                need2fite.beginFight(randomPersonOne, randomPersonTwo);
            }

            //Create Person
            case (2) -> {
                CharacterPage characterPage = new CharacterPage(Paths.get(getSettings().getSetting("Save_Location")));
                while(runPage) {
                    runPage = characterPage.runPage();
                };
            }

            //Settings
            case (8) -> {
                SettingsPage settingsPage = new SettingsPage(getSettings());
                while(runPage) {
                    runPage = settingsPage.runPage();
                }
            }

            //Exit
            case (9) -> {
                isOn = exit();
            }
        }
        return isOn;
    }

    /*@Override
    public void changePage() {
        switch (chosenOption()) {
            //Play
            case (1) -> {
                FightBattle need2fite = new FightBattle();
                Actor randomPersonOne = ActorGeneration.createChar();
                Actor randomPersonTwo = ActorGeneration.createChar();
                need2fite.beginFight(randomPersonOne, randomPersonTwo);
            }

            //Create Person
            case (2) -> {
                characterPage();
            }

            //Settings
            case (8) -> {
                settingsPage();
            }

            //Exit
            case (9) -> {
                System.out.println("Goodbye!");
                isOn = false;
            }
            default -> {
                System.out.println("Please input a valid number.");
            }
        }
    }*/
}
