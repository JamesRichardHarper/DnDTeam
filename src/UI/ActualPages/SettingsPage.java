package UI.ActualPages;

import Settings.Options;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SettingsPage implements InteractivePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";
    private Options settings;

    public SettingsPage(Options settings) {
        this.settings = settings;
        pageActions.add(new PageOption(1,"Change Save Location", () -> updateSetting(settings)));
        setPageOptions(pageActions);

        this.menu = MenuFactory.makeMenu(
                "Settings Menu",
                String.format("""
                            Save Location: %s
                            """, settings.getSetting("Save_Location")),
                pageActions);
    }

    public void setMenu() {
        this.menu = MenuFactory.makeMenu(
                "Settings Menu",
                String.format("""
                            Save Location: %s
                            """, settings.getSetting("Save_Location")),
                getPageActions());
    }

    public Options getSettings() {
        return settings;
    }

    public boolean updateSetting(Options settings){
        String initialPath = Input.getVariableString("save location").trim();
        try{
            Paths.get(initialPath);
            settings.updateSetting("Save_Location", initialPath);
        }catch(InvalidPathException exception){
            System.out.println("Can't save new location due to: " + exception.getReason());
            return false;
        }
        setMenu();
        return true;
    }

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
        return "Settings";
    }
}
