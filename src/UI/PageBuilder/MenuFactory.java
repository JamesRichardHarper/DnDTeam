package UI.PageBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuFactory {
    public static String makeMenu(String title, String subtitle, ArrayList<PageOption> actionsTotal){
        String finalText = "";
        ArrayList<String> builderString = makeBase(title, subtitle);

        for(PageOption actions:actionsTotal){
            builderString.add(String.format("[%s] - %s", actions.getNumberInput(), actions.getActionText()));
        }

        for(String text:builderString){
            finalText = String.format("%s\n%s", finalText, text);
        }
        return finalText;
    }

    public static String makeMenu(String title, String subtitle, String ternaryTitle){
        String finalText = "";
        ArrayList<String> builderString = makeBase(title, subtitle);
        if(!ternaryTitle.isEmpty()){
            builderString.add(ternaryTitle);
        }
        for(String text:builderString){
            finalText = String.format("%s\n%s", finalText, text);
        }
        return finalText;
    }

    public static ArrayList<String> makeBase(String title, String subtitle){
        ArrayList<String> builderString = new ArrayList<>();

        if(!title.isEmpty()){
            builderString.add(title);
        }
        if(!subtitle.isEmpty()){
            builderString.add(subtitle);
        }

        return builderString;
    }
    /*public static String checkEmpty(String text){
        if
    }*/
}
