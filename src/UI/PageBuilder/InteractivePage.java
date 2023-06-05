package UI.PageBuilder;
import java.util.Arrays;

public interface InteractivePage {
    PageOption[] getPageActions();
    String getMenu();
    boolean runPage();
    default int chosenOption(int input){
        return checkInput(getPageActions(), input);
    }

    default int checkInput(PageOption[] actions, int input){
        boolean validInput = false;
        while(!validInput){
            try{
                return Arrays.stream(actions)
                        .filter(Action -> Action.getNumberInput() == input)
                        .findFirst().get().getNumberInput();

            }
            catch(Exception exception){
                System.out.println("Not a valid step, try again.");
            }
        }
        return 
    }

    default boolean exit(){
        System.out.println("Returning");
        return false;
    }
}
