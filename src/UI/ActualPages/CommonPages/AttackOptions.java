package UI.ActualPages.CommonPages;

import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;
import UI.PageBuilder.SingleUsePage;

import java.util.ArrayList;

public class AttackOptions implements SingleUsePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";

    public AttackOptions() {
        pageActions.add(new PageOption(1,"Strength", () -> true));
        pageActions.add(new PageOption(2,"Knowledge", () -> false));
        pageActions.add(new PageOption(2,"Wisdom", () -> false));

        this.menu = MenuFactory.makeMenu("Which stat do you wish to use.",
                "",
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
}
