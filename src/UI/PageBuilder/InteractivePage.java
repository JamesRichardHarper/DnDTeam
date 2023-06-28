package UI.PageBuilder;
import Settings.Options;
import UI.Input;

import java.util.ArrayList;

public interface InteractivePage {
    ArrayList<PageOption> getPageActions();
    String getMenu();
    String getActionTitle();
    default boolean startPage() {
        boolean pageNotFinished = true;
        while(pageNotFinished){
            boolean actionNotFinished = true;
            while(actionNotFinished){
                boolean validInput = false;
                PageOption chosenOne;
                System.out.println(getMenu());
                while(!validInput) {
                    chosenOne = returnInput(getPageActions(), Input.readInt());
                    actionNotFinished = chosenOne.getAction().get();
                    validInput = validChoice(chosenOne);
                    if(chosenOne.getActionText().equals("Exit")){
                        pageNotFinished = false;
                    }
                }
            }

        }
        return false;
    }

    default void setPageOptions(ArrayList<PageOption> actions){
        actions.add(new PageOption(actions.size()+1,  "Exit", this::exit));
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
                        new PageOption(0, "Invalid", this::invalidPage)
                );
    }

    /*
    Will return the chosen action unless the input is invalid.
    In which case, the user will be redirected to pick an option
     */
    default boolean running(ArrayList<PageOption> actions){
        PageOption chosenOne = returnInput(actions, Input.readInt());
        return chosenOne.getAction().get() && !chosenOne.getActionText().equals("Exit");
    }

    default boolean invalidPage(){
        System.out.println("Invalid page action chosen.\nPlease try again.");
        return true;
    }

    default boolean validChoice(PageOption chosenOne){
        return chosenOne.getNumberInput() != 0;
    }

    /*

    this.menu = MenuFactory.makeMenu(
                "Settings Menu",
                String.format("""
                            Save Location: %s
                            """, settings.getSetting("Save_Location")),
                pageActions);

     */

    /*default String returnMenu(String title, String subTitle, Options pageOptions){

    }*/

    default boolean exit(){
        System.out.println("Returning");
        return false;
    }
}
