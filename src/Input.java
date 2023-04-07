import java.util.Scanner;

public class Input {
    private static Input instance = new Input();
    private Scanner keyboardInput = new Scanner(System.in);

    private Input(){}

    public static Input getInstance(){
        if (instance == null){
            instance = new Input();
        }
        return instance;
    }

    public String readString(){
        return keyboardInput.nextLine();
    }

    public int readInt(){
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
}
