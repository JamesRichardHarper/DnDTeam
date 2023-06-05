import UI.ActualPages.OpeningPage;

public class Main {
    public static void main(String[] args) {
        OpeningPage openingPage = new OpeningPage();
        boolean isOn = true;
        while(isOn){
            isOn = openingPage.runPage();
        }
    }
}
