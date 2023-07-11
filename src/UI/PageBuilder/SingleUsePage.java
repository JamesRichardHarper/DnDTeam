package UI.PageBuilder;

import UI.Input;

import java.util.ArrayList;

public interface SingleUsePage extends InteractivePage {
    @Override
    default boolean startPage() {
        boolean validInput = false;
        boolean answer = false;
        System.out.println(getMenu());
        PageOption chosenOne;
        while(!validInput) {
            chosenOne = returnInput(getPageActions(), Input.readInt());
            answer = chosenOne.getAction().get();
            if (chosenOne.getNumberInput()!=0){
                validInput = true;
            }
        }
        return answer;
    }
}
