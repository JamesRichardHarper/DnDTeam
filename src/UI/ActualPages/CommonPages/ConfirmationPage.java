package UI.ActualPages.CommonPages;

import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

public class ConfirmationPage implements InteractivePage {
    private final PageOption[] pageActions = new PageOption[2];
    private String menu = "";

    public ConfirmationPage(String confirmationOf) {
        this.pageActions[0] = new PageOption(1,"Yes", () -> true);
        this.pageActions[1] = new PageOption(2,"No", () -> false);

        this.menu = MenuFactory.makeMenu(
                String.format("Are you wanting to %s?", confirmationOf),
                "".trim(),
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
    public boolean runPage() {
        boolean confirm = false;

        System.out.println(getMenu());

        switch (chosenOption(Input.readInt())){
            case(1) -> {
                confirm = true;
            }
            case(2) -> {
                confirm = false;
            }
        }
        return confirm;
    }
}
