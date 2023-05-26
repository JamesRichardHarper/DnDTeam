package UI.ActualPages;

import BattleClasses.FightBattle;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.util.Arrays;
import java.util.function.Consumer;

public class OpeningPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[4];
    private String menu = "";

    public OpeningPage(){
        this.pageActions[0] = new PageOption(1,"Play", (Consumer<Runnable>) new OpeningPage());
        this.pageActions[1] = new PageOption(2,"Create Random Character", (Consumer<Runnable>) new OpeningPage());
        this.pageActions[2] = new PageOption(8,"Settings", (Consumer<Runnable>) new OpeningPage());
        this.pageActions[3] = new PageOption(9,"Quit", (Consumer<Runnable>) new OpeningPage());

        this.menu = MenuFactory.makeMenu(
                "Welcome!",
                "What is it you would like to do?",
                pageActions);
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
    public void chosenOption(){
        System.out.println(getMenu());
        PageOption activePage = Arrays.stream(getPageActions())
                .filter(Action -> Action.getNumberInput() == Input.readInt())
                .findFirst().get();
        activePage.getAction();
    }

    @Override
    public void changePage() {

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
