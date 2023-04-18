package UI;

import BattleClasses.FightBattle;
import BattleClasses.FightGame;
import CharacterClasses.Actor;
import CharacterClasses.RandomActor;

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
                                FightBattle need2fite = new FightBattle();
                                RandomActor needAnActor = new RandomActor();
                                Actor randomPersonOne = needAnActor.createChar();
                                Actor randomPersonTwo = needAnActor.createChar();
                                need2fite.beginFight(randomPersonOne, randomPersonTwo);
                                break;
                        }
                        //Create Random Person
                        case(2):{
                                System.out.println("Sure thing!");
                                //Remember to delete this and the import, it's temporary
                                RandomActor needAnActor = new RandomActor();
                                Actor randomPerson = needAnActor.createChar();
                                System.out.println("\n" + randomPerson.toString());
                                break;
                        }
                        //Exit
                        case(9):{
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
