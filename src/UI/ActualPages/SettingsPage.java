package UI.ActualPages;

import Settings.Options;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

public class SettingsPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[2];
    private String menu = "";
    private Options settings;

    public SettingsPage(Options settings) {
        this.settings = settings;
        this.pageActions[0] = new PageOption(1,"Change Save Location", () -> true);
        this.pageActions[1] = new PageOption(2,"Quit", () -> true);

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

        switch(chosenOption(Input.readInt())){
            case(1) -> {
                getSettings().updateSetting("Save_Location",
                        Input.getVariableString("save location"));
            }
            case(9) -> {
                isOn = exit();
            }
        }
        return isOn;
    }
}
