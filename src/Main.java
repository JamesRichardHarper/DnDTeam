import UI.Input;
import UI.Pages;

public class Main {
    public static void main(String[] args) {
        boolean isOn = true;

        /*while(isOn){
            isOn = Pages.getInstance().openingPage(true);
        }*/

        while(isOn){
            isOn = Pages.getInstance().openingPage();
        }
    }
}
