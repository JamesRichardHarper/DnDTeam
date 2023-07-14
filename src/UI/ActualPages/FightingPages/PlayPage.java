package UI.ActualPages.FightingPages;

import BattleClasses.FightBattle;
import CharacterClasses.Actor;
import CharacterClasses.ActorGeneration;
import Settings.Options;
import Settings.WriteReadCharacter;
import UI.ActualPages.CommonPages.ConfirmationPage;
import UI.ActualPages.CommonPages.TextBox;
import UI.Input;
import UI.PageBuilder.InteractivePage;
import UI.PageBuilder.MenuFactory;
import UI.PageBuilder.PageOption;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlayPage implements InteractivePage {
    private final ArrayList<PageOption> pageActions = new ArrayList<>();
    private String menu = "";
    private Actor activeCharacter;
    private Options settings;

    public PlayPage(Options settings) {
        this.settings = settings;
        pageActions.add(new PageOption(1,"Battle!", this::playGame));
        pageActions.add(new PageOption(2,"Load a character", this::canLoadActor));
        setPageOptions(pageActions);

        this.menu = MenuFactory.makeMenu(
                """
                        Welcome!
                        What is it you wish to do?""",
                new TextBox(actorSummary(activeCharacter)).getFinalText(),
                pageActions);
    }

    public Options getSettings(){return settings;}

    public void setMenu(){
        this.menu = MenuFactory.makeMenu(
                """
                        Welcome!
                        What is it you wish to do?""",
                new TextBox(actorSummary(getActiveCharacter())).getFinalText(),
                pageActions);
    }

    public Actor getActiveCharacter() {
        return activeCharacter;
    }

    public void setActiveCharacter(Actor activeCharacter) {
        this.activeCharacter = activeCharacter;
        setMenu();
    }

    public String actorSummary(Actor actor){
        if(actor == null){
            return "No active character!";
        }
        else{
            return String.format("Active Player: %s", actor.getName());
        }
    }

    public boolean canLoadActor(){
        Actor loadedActor = loadActor(Paths.get(getSettings().getSetting("Save_Location")));
        if (loadedActor == null){
            System.out.println("No Character Found!");
            return false;
        }
        else{
            loadedActor.setPlayerControlled(true);
            setActiveCharacter(loadedActor);
            System.out.println("Character Loaded!");
            return true;
        }
    }

    public Actor loadActor(Path saveLocation){
        String characterToLoad = Input.getVariableString("name of the character");
        return (WriteReadCharacter.unpackActor(saveLocation.resolve(Path.of(characterToLoad)).toString()));
    }

    public boolean playGame(){
        Actor playerOne;
        Actor playerTwo = ActorGeneration.createChar();
        ConfirmationPage confirmationPage = new ConfirmationPage("play with a loaded character");
        if(getActiveCharacter() == null){
            playerOne = ActorGeneration.createChar();
        }
        else{
            if(confirmationPage.startPage()){
                getActiveCharacter().setPlayerControlled(true);
                playerOne = getActiveCharacter();
            }
            else{
                playerOne = ActorGeneration.createChar();
            }
        }
        FightBattle fightBattle = new FightBattle(playerOne, playerTwo);
        fightBattle.beginFight();
        return true;
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
        return "Start A Fight!";
    }
}
