package UI.PageBuilder;

import java.util.function.Consumer;

public class PageOption {
    int numberInput;
    String actionText;

    public PageOption(int numberInput, String actionText) {
        this.numberInput = numberInput;
        this.actionText = actionText;
    }

    public int getNumberInput() {
        return numberInput;
    }

    public String getActionText() {
        return actionText;
    }


}
