package UI.PageBuilder;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuFactory {
    public static String makeMenu(String title, String subtitle, PageOption[] actionsTotal){
        String finalText = "";
        ArrayList<String> builderString = new ArrayList<>();

        if(!title.isEmpty()){
            builderString.add(title);
        }
        if(!subtitle.isEmpty()){
            builderString.add(subtitle);
        }

        for(PageOption actions:actionsTotal){
            builderString.add(String.format("[%s] - %s", actions.getNumberInput(), actions.getActionText()));
        }

        for(String text:builderString){
            finalText = String.format("%s\n%s", finalText, text);
        }
        return /*String.format("""
                %1s
                %2s
                %3s
                """,
                title,
                subtitle,
                finalText);*/
        finalText;
    }

    /*public static String checkEmpty(String text){
        if
    }*/
}
