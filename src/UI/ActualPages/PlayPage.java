package UI.ActualPages;

import CharacterClasses.Actor;
import Settings.Options;
import Settings.WriteReadCharacter;
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
    private Path saveLocation;
    /*private final InteractivePage[] pages = {
            new CharacterPage()
    };*/

    public PlayPage(Path saveLocation) {
        this.saveLocation = saveLocation;
        pageActions.add(new PageOption(1,"Battle!", () -> true));
        pageActions.add(new PageOption(2,"Load a character", this::canLoadActor));
        setPageOptions(pageActions);

        this.menu = MenuFactory.makeMenu(
                """
                        Welcome!
                        What is it you wish to do?""",
                new TextBox(actorSummary(activeCharacter)).getFinalText(),
                pageActions);
    }

    public Actor getActiveCharacter() {
        return activeCharacter;
    }

    public void setActiveCharacter(Actor activeCharacter) {
        this.activeCharacter = activeCharacter;
    }

    public Path getSaveLocation() {
        return saveLocation;
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
        Actor loadedActor = loadActor(getSaveLocation());
        if (loadedActor == null){
            System.out.println("No Character Found!");
            return false;
        }
        else{
            setActiveCharacter(loadedActor);
            System.out.println("Character Loaded!");
            return true;
        }
    }

    public Actor loadActor(Path saveLocation){
        String characterToLoad = Input.getVariableString("name of the character");
        return WriteReadCharacter.unpackActor(saveLocation.resolve(Path.of(characterToLoad)).toString());
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
