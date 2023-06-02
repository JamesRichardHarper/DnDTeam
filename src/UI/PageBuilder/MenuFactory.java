package UI.PageBuilder;
import java.util.Arrays;

public class MenuFactory {
    public static String makeMenu(String title, String subtitle, PageOption[] actionsTotal){
        String finalText = "";

        for(PageOption actions:actionsTotal){
            finalText = String.format("%s[%s] - %s\n", finalText, actions.getNumberInput(), actions.getActionText());
        }
        return String.format("""
                %1s
                %2s
                %3s
                """,
                title,
                subtitle,
                finalText);
    }
}
