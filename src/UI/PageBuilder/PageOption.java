package UI.PageBuilder;

import java.util.function.Consumer;

public class PageOption {
    int numberInput;
    String actionText;
    Consumer<Runnable> action;

    public PageOption(int numberInput, String actionText, Consumer<Runnable> action) {
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

    public Consumer<Runnable> getAction() {
        return action;
    }
}
