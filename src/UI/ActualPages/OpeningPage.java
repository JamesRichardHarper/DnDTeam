package UI.ActualPages;

import Settings.Options;
import UI.ActualPages.FightingPages.PlayPage;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.nio.file.Paths;
import java.util.ArrayList;

public class OpeningPage implements InteractivePage {
    private Options settings = new Options();
    private String menu = "";
    private final InteractivePage[] pages = {
            new PlayPage(getSettings()),
            new CharacterPage(getSettings()),
            new SettingsPage(getSettings())
    };
    private ArrayList<PageOption> pageActions;

    public OpeningPage(){
        pageActions = setPageOptions(pages);

        this.menu = MenuFactory.makeMenu(
                "Welcome!",
                "What is it you would like to do?",
                pageActions);
    }

    public Options getSettings(){return settings;}

    @Override
    public ArrayList<PageOption> getPageActions() {
        return pageActions;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public String getActionTitle() {
        return null;
    }

    @Override
    public boolean exit() {
        System.out.println("Goodbye!");
        return false;
    }
}
