package UI;
public class BulkText {

    //Hard Coded Text
    public static void printIntroduction(){
        System.out.println("""
                Greetings!\s
                What is it you would like to do?\s
                [1] Play\s
                [2] Create Random Character\s
                [9] Quit""");
    }

    public static void randomCharacterPage(){
        System.out.println("""
                Sure!\s
                Here's one now:\s
                """);

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
        System.out.printf("""
                Okay!\s
                Please enter the %s wanted for this character. %n""",
                variableNeeded);
    }


}
