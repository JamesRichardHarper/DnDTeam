package UI.ActualPages;

import Settings.Options;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

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

    public Options getSettings() {
        return settings;
    }

    public boolean updateSetting(Options settings){
        settings.updateSetting("Save_Location", Input.getVariableString("save location"));
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
