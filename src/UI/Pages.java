package UI;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;

public final class Pages {
        boolean isOn;
        private static Pages instance;

        private Pages() {
        }

        public static Pages getInstance() {
                if (instance == null) {
                        instance = new Pages();
                }

                return instance;
        }

        public boolean openingPage(boolean isOn) {
                this.isOn = isOn;
                BulkText.printIntroduction();
                int inputOpening = Input.readInt();

                switch (inputOpening) {
                        //Play
                        case (1) -> {
                                FightBattle need2fite = new FightBattle();
                                ActorGeneration needAnActor = new ActorGeneration();
                                Actor randomPersonOne = needAnActor.createChar();
                                Actor randomPersonTwo = needAnActor.createChar();
                                need2fite.beginFight(randomPersonOne, randomPersonTwo);
                        }

                        //Create Person
                        case (2) -> {
                                characterPage();
                        }

                        //Exit
                        case (9) -> {
                                System.out.println("Goodbye!");
                                isOn = false;
                        }
                        default -> {
                                System.out.println("Please input a valid number.");
                        }
                }

                return isOn;

        }

        public void characterPage() {
                ActorGeneration needAnActor = new ActorGeneration();
                boolean randomName = PageMethods.randomNameCheck();
                boolean randomChar = PageMethods.randomCharacterCheck();
                Actor activeCharacter;

                BulkText.printCharacterPage();
                int inputCharacter = Input.readInt();

                randomName? (
                        randomChar? (
                                activeCharacter = needAnActor.createChar()
                        ) : (
                                activeCharacter = needAnActor.createChar(PageMethods.getVariableName("Name"))
                )
                ) : (   randomChar? (
                                activeCharacter = needAnActor.
                        ) : (
                                activeCharacter = needAnActor.createChar(
                                        PageMethods.getVariableName("Name"),
                                        getVariableInt("Health"),
                                        getVariableInt("Stamina"),
                                        getVariableInt("Strength"),
                                        getVariableInt("Knowledge"),
                                        getVariableInt("Willpower")
                                )
                        ));

                switch (inputCharacter) {
                        //Create Random
                        case (1) -> {
                                if (randomName){
                                        Actor newCharacter = needAnActor.createChar(needAnActor.getRandomName());
                                }
                                else{
                                        Actor newCharacter = needAnActor.createChar();
                                }
                        }

                        //Create Non-Random Person
                        case (2) -> {
                                Actor randomPerson = needAnActor.createChar();
                                System.out.println("\n" + randomPerson.toString());
                        }

                        //Exit
                        case (9) -> {
                                System.out.println("Goodbye!");
                        }
                        default -> {
                                System.out.println("Please input a valid number.");
                        }
                }
        }

        /*public void templatePage(){
                BulkText.printTemplatePage();
                int inputCharacter = Input.readInt();
                String intputString = Input.readString();
        }*/
}
