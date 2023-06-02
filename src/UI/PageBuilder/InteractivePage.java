package UI.PageBuilder;

import UI.Input;

import java.util.Arrays;

public interface InteractivePage {
    PageOption[] getPageActions();
    String getMenu();
    void runPage();
    default int chosenOption(int input){
        System.out.println(getMenu());
        return checkInput(getPageActions(), Input.readInt());
    }

    default int checkInput(PageOption[] actions, int input){
        while(true){
            try{
                return Arrays.stream(actions)
                        .filter(Action -> Action.getNumberInput() == input)
                        .findFirst().get().getNumberInput();

            }
            catch(Exception exception){
                System.out.println("Not a valid step, try again.");
            }
        }
    }
}
