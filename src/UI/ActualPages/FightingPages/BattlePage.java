package UI.ActualPages.FightingPages;

import CharacterClasses.Actor;
import UI.ActualPages.CommonPages.TextBox;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.util.ArrayList;

public class BattlePage implements InteractivePage {

    private Actor playerOne;
    private Actor playerTwo;
    private String menu;

    public BattlePage(Actor playerOne, Actor playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.menu = new TextBox(
                        MenuFactory.makeMenu(
                        """
                                Welcome to the fight!""",
                        "Today we have:",
                        playerOne.getName() + "Vs." + playerTwo.getName())
                    )
                .getFinalText();
    }

    @Override
    public ArrayList<PageOption> getPageActions() {
        return null;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public String getActionTitle() {
        return "Round container";
    }
}
