package UI.PageBuilder;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PageOption {
    int numberInput;
    String actionText;
    Supplier<Boolean> action;

    public PageOption(int numberInput, String actionText, Supplier<Boolean> action) {
        this.numberInput = numberInput;
        this.actionText = actionText;
        this.action = action;
    }

    public int getNumberInput() {
        return numberInput;
    }

    public String getActionText() {
        return actionText;
    }


}
