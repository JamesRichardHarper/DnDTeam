package UI.PageBuilder;
import UI.Input;

import java.util.ArrayList;

public interface InteractivePage {
    ArrayList<PageOption> getPageActions();
    String getMenu();
    String getActionTitle();
    boolean startPage();

    default void setPageOptions(ArrayList<PageOption> actions){
        actions.add(new PageOption(actions.size()+1,  "Exit", () -> false));
    }

    default ArrayList<PageOption> setPageOptions(InteractivePage[] pagesUsed){
        int index = 1;
        ArrayList<PageOption> totalActions = new ArrayList<>();
        for(InteractivePage page:pagesUsed){
            PageOption pageOption = new PageOption(index, page.getActionTitle(), page::startPage);
            totalActions.add(pageOption);
            index++;
        }
        setPageOptions(totalActions);
        return totalActions;
    }

    default PageOption returnInput(ArrayList<PageOption> actions, int input){
        return actions.stream()
                .filter(Action -> Action.getNumberInput() == input)
                .findFirst().orElse(
                        new PageOption(0, "", this::invalidPage)
                );
    }

    default boolean running(ArrayList<PageOption> actions){
        PageOption chosenOne = returnInput(actions, Input.readInt());
        return chosenOne.getAction().get() || !chosenOne.getActionText().equals("Exit");
    }

    default boolean invalidPage(){
        System.out.println("Invalid page action chosen.\nPlease try again.");
        return true;
    }

    default boolean exit(){
        System.out.println("Returning");
        return false;
    }
}
