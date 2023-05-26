package UI;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Settings.Options;
import UI.ActualPages.OpeningPage;

import java.nio.file.Paths;

public final class Pages {
        boolean isOn;
        Options settings = new Options();
        private static Pages instance;

        private Pages() {
        }

        public static Pages getInstance() {
                if (instance == null) {
                        instance = new Pages();
                }

                return instance;
        }

        public boolean openingPageOld(boolean isOn) {
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

                        //Settings
                        case (8) -> {
                                settingsPage();
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

        public boolean openingPageSecondOld(boolean isOn) {
                this.isOn = isOn;
                OpeningPage openingPage = new OpeningPage();
                System.out.println(openingPage.getMenu());
                int input = Input.readInt();
                switch (input) {
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

                        //Settings
                        case (8) -> {
                                settingsPage();
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

        public Boolean openingPage() {
                OpeningPage openingPage = new OpeningPage();
                openingPage.chosenOption();
                return false;
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

                if(PageMethods.savingChar(activeCharacter)){
                        PageMethods.saveActor(activeCharacter, Paths.get(settings.getSetting("Save_Location")));
                }
        }

        public void settingsPage(){
                BulkText.printSettingsPage(settings.getSetting("Save_Location"));
                int inputCharacter = Input.readInt();

                switch(inputCharacter){
                        case(1) -> {
                                System.out.println("Enter New Location");
                                String newPathLocation = Input.readString();
                                settings.updateSetting("Save_Location",
                                        newPathLocation);
                        }
                        case(9) -> {
                                System.out.println("Backing out.");
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
