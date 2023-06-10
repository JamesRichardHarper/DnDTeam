package UI.ActualPages.CommonPages;

import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.util.ArrayList;

public class ConfirmationPage implements InteractivePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";

    public ConfirmationPage(String confirmationOf) {
        pageActions.add(new PageOption(1,"Yes", () -> true));
        pageActions.add(new PageOption(2,"No", () -> false));

        this.menu = MenuFactory.makeMenu(
                String.format("Are you wanting to %s?", confirmationOf),
                "".trim(),
                pageActions);
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
        return null;
    }

    @Override
    public boolean startPage() {
        boolean isOn = true;
        boolean confirm = false;

        System.out.println(getMenu());

        while(isOn){
            isOn = running(getPageActions());
        }
        return confirm;
    }
}
