package UI;
public class BulkText {
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
                [2] Create\s
                [9] Return""");
    }

    public static void printRandomNamePage(){
        System.out.println("""
                Okay!\s
                Do you want your own name?\s
                [1] No\s
                [2] Yes""");
    }

    public static void printCustomVariable(String variableNeeded){
        System.out.println("""
                Okay!\s
                Please enter the $variableNeeded wanted for this character.""");
    }
}
