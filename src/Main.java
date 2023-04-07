public class Main {
    public static void main(String[] args) {
        Input.getInstance();

        Boolean isOn = true;

        while(isOn){
            System.out.println("Hello, would you like to quit?");
            String keyboardInput = Input.getInstance().readString();
            if (keyboardInput.toUpperCase().equalsIgnoreCase("Y")){
                isOn = false;
            }
            else{
                System.out.println("Want to try that again?");
            }
        }


    }
}