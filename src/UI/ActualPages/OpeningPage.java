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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class OpeningPage implements InteractivePage {
    private final Options settings = new Options();
    private String menu = "";
    private final InteractivePage[] pages = {
            new CharacterPage(Paths.get(getSettings().getSetting("Save_Location"))),
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
    public boolean startPage() {
        boolean isOn = true;
        while(isOn){
            System.out.println(getMenu());
            isOn = running(getPageActions());
        }
        return false;
    }

}
