package UI.PageBuilder;
import java.util.Arrays;

public interface InteractivePage {
    PageOption[] getPageActions();
    String getMenu();
    boolean runPage();
    default int chosenOption(int input){
        return returnInput(getPageActions(), input);
    }

    default int returnInput(PageOption[] actions, int input){
        try{
            return Arrays.stream(actions)
                    .filter(Action -> Action.getNumberInput() == input)
                    .findFirst().get().getNumberInput();

        }
        catch(Exception exception){
            System.out.println("Please enter a valid value");
            return 0;
        }
    }

    default boolean exit(){
        System.out.println("Returning");
        return false;
    }
}
