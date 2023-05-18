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
                                Actor randomPersonOne = ActorGeneration.createChar();
                                Actor randomPersonTwo = ActorGeneration.createChar();
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
                boolean randomName = PageMethods.randomNameCheck();
                boolean randomChar = PageMethods.randomCharacterCheck();
                Actor activeCharacter;

                if (randomName) {
                        if (randomChar) { //Random Name w/ random character
                                activeCharacter = ActorGeneration.createChar();
                        } else { //Random Name w/ custom character
                                activeCharacter = PageMethods.createUserActor(ActorGeneration.getRandomName());
                        }
                } else {
                        if (randomChar) { //Custom Name w/ random character
                                activeCharacter = ActorGeneration.createChar(BulkText.getVariableString("Name"));
                        } else { //Custom Name w/ custom character
                                activeCharacter = PageMethods.createUserActor();
                        }
                }

                System.out.println(activeCharacter);
        }

        /*public void templatePage(){
                BulkText.printTemplatePage();
                int inputCharacter = Input.readInt();
                String intputString = Input.readString();
        }*/
}
