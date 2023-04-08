import UI.Input;
import UI.Pages;

public class Main {
    public static void main(String[] args) {
        Boolean isOn = true;

        while(isOn){
            isOn = Pages.getInstance().openingPage(isOn);
        }

    }
}
