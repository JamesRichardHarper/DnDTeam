package UI;
public class BulkText {

    //Hard Coded Text
    public static void printIntroduction(){
        System.out.println("""
                Greetings!\s
                What is it you would like to do?\s
                [1] Play\s
                [2] Create Random Character\s
                [8] Settings\s
                [9] Quit""");
    }

    public static void printCharacterPage(){
        System.out.println("""
                Okay!\s
                Do you want to generate a random character, or create one yourself?\s
                [1] Random\s
                [2] Create\s""");
    }

    public static void printRandomNamePage(){
        System.out.println("""
                Okay!\s
                Do you want your own name?\s
                [1] No\s
                [2] Yes""");
    }

    //Formatted Text
    public static String getVariableString(String variableNeeded){
        BulkText.printCustomVariable(variableNeeded);
        return Input.readString();
    }

    public static int getVariableInt(String variableNeeded){
        BulkText.printCustomVariable(variableNeeded);
        return Input.readInt();
    }

    public static void printCustomVariable(String variableNeeded){
        System.out.printf(
                """
                Please enter the %s wanted.
                """,
                variableNeeded);
    }

    public static void printSettingsPage(String saveLocation){
        System.out.printf("""
                Settings
                Save Location: %s
                [1] Change Save Location
                [9] Return
                """,
                saveLocation
        );
    }

    public static void printGeneratedChar(String charStats){
        System.out.printf("""
                Here is your character!
                -----------------------
                %s
                -----------------------
                Do you wish to save?
                [1] Yes
                [2] No
                """,
                charStats);
    }

}
