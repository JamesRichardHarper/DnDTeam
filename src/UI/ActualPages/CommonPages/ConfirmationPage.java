package UI.ActualPages.CommonPages;

import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

public class ConfirmationPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[2];
    private String menu = "";

    public ConfirmationPage(String confirmationOf) {
        this.pageActions[0] = new PageOption(1,"Yes");
        this.pageActions[1] = new PageOption(2,"No");

        this.menu = MenuFactory.makeMenu(
                confirmationOf,
                "",
                pageActions);
    }

    @Override
    public PageOption[] getPageActions() {
        return new PageOption[0];
    }

    @Override
    public String getMenu() {
        return null;
    }

    @Override
    public void runPage() {

    }
}
