package UI.ActualPages.CommonPages;

import UI.Input;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;
import UI.PageBuilder.SingleUsePage;

import java.util.ArrayList;

public class AttackOptions implements SingleUsePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";
    private String stat;

    public AttackOptions() {
        pageActions.add(new PageOption(1,"Strength", () -> true));
        pageActions.add(new PageOption(2,"Knowledge", () -> true));
        pageActions.add(new PageOption(3,"Willpower", () -> true));

        this.menu = MenuFactory.makeMenu("Which stat do you wish to use.",
                "",
                pageActions);
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
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
        return "Stat usage";
    }

    @Override
    public boolean startPage() {
        boolean validInput = false;
        String answer;
        System.out.println(getMenu());
        PageOption chosenOne;
        while(!validInput) {
            chosenOne = returnInput(getPageActions(), Input.readInt());
            answer = chosenOne.getActionText();
            if (chosenOne.getNumberInput()!=0){
                validInput = true;
                setStat(answer);
            }
        }
        return validInput;
    }
}
