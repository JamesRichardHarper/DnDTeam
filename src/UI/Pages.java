package UI;

public final class Pages {
        boolean isOn;
        private static Pages instance;

        private Pages(){};

        public static Pages getInstance(){
                if(instance == null){
                        instance = new Pages();
                }

                return instance;
        }

        public boolean openingPage(boolean isOn){
                this.isOn = isOn;
                BulkText.printIntroduction();
                int input = Input.readInt();
                switch(input){
                        //Play
                        case(1):{
                                System.out.println("Implementation coming soon!");
                                break;
                        }
                        //Exit
                        case(2):{
                                System.out.println("Goodbye!");
                                isOn = false;
                                break;
                        }
                        default:{
                                System.out.println("Please input a valid number.");
                        }
                }

                return isOn;

        }
}
