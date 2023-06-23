package UI.ActualPages;

import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import CharacterInnates.Attribute;
import CharacterInnates.TotalAbility;
import Settings.WriteReadCharacter;
import UI.ActualPages.CommonPages.ConfirmationPage;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CharacterPage implements InteractivePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";
    private Actor activeCharacter;
    private Path saveLocation;

    public CharacterPage(Path saveLocation){
        this.saveLocation = saveLocation;
        pageActions.add(new PageOption(1,"Random Stats - Random Name", this::createAllRandom));
        pageActions.add(new PageOption(2,"Random  Stats - Custom Name", this::createRandomStatsCustomName));
        pageActions.add(new PageOption(3,"Custom Stats - Random Name", this::createCustomStatsRandomName));
        pageActions.add(new PageOption(4,"Custom Stats - Custom Name", this::createAllCustom));
        setPageOptions(pageActions);

        this.menu = MenuFactory.makeMenu(
                "What kind of character do you want to make?",
                """
                        A completely random character will have all stats randomised, as well as having a random name.
                        A custom character will have the option of creating its' own stats, as well as having a personalised name.""",
                pageActions);
    }

    public Path getSaveLocation(){ return saveLocation;}

    public Actor getActiveCharacter() {
        return activeCharacter;
    }

    public void setActiveCharacter(Actor activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    @Override
    public ArrayList<PageOption> getPageActions() {
        return pageActions;
    }

    @Override
    public String getMenu() {
        return menu;
    }

    @Override
    public String getActionTitle() {
        return "Create a character";
    }

    public String printGeneratedChar(String charStats){
        return String.format("""
                Here is your character!
                -----------------------
                %s
                -----------------------""",
                charStats);
    }

    public void saveActor(Actor userChar, Path location){
        WriteReadCharacter.packActor(userChar, location);
    }

    public boolean checkSave(){
        System.out.println(printGeneratedChar(getActiveCharacter().toString()));
        ConfirmationPage confirmationPage = new ConfirmationPage("save character");
        if(confirmationPage.startPage()){
            saveActor(getActiveCharacter(),getSaveLocation());
        }
        return true;
    }

    public Attribute generateUserAttribute(String name){
        return ActorGeneration.generateAttribute(
                Input.getVariableInt(String.format("%s capacity", name)),
                Input.getVariableInt(String.format("%s regen", name)),
                name);
    }

    public TotalAbility generateUserAbility(String name){
        return ActorGeneration.generateTotalAbility(
                name,
                Input.getVariableInt(String.format("%s score", name)));
    }

    public Boolean createAllRandom(){
        setActiveCharacter(ActorGeneration.createChar());
        return checkSave();
    }

    public Boolean createRandomStatsCustomName(){
        setActiveCharacter(
                ActorGeneration.createChar(
                        Input.getVariableString("Name")
                )
        );
        return checkSave();
    }

    public Boolean createCustomStatsRandomName(){
        setActiveCharacter(
                ActorGeneration.createChar(
                        Input.getVariableString("name"),
                        generateUserAttribute("Health"),
                        generateUserAttribute("Stamina"),
                        generateUserAbility("Strength"),
                        generateUserAbility("Knowledge"),
                        generateUserAbility("Willpower")
                )
        );
        return checkSave();
    }

    public Boolean createAllCustom(){
        setActiveCharacter(
                ActorGeneration.createChar(
                        Input.getVariableString("name"),
                        generateUserAttribute("Health"),
                        generateUserAttribute("Stamina"),
                        generateUserAbility("Strength"),
                        generateUserAbility("Knowledge"),
                        generateUserAbility("Willpower")
                )
        );
        return checkSave();
    }
}
