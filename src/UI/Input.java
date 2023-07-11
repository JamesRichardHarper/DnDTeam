package UI;

import java.util.Scanner;

public class Input {
    private static final Scanner keyboardInput = new Scanner(System.in);

    public static String readString(){
        return keyboardInput.nextLine();
    }

    public static int readInt(){
        int value = 0;
        boolean valid = false;

        while(!valid){
            try{
                value = Integer.parseInt(keyboardInput.nextLine());
                valid = true;
            } catch (NumberFormatException e){
                System.out.println("Not a valid value. Please input a number");
            }
        }
        return value;

    }

    public static String getVariableString(String variableNeeded){
        System.out.println(printCustomVariableNeeded(variableNeeded));
        return Input.readString();
    }

    public static int getVariableInt(String variableNeeded){
        System.out.println(printCustomVariableNeeded(variableNeeded));
        return Input.readInt();
    }

    public static String printCustomVariableNeeded(String variableNeeded){
        return String.format("""
                Please enter the %s wanted.""",
                variableNeeded);
    }
}
