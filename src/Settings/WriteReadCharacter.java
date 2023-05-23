package Settings;

import CharacterClasses.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteReadCharacter {
    Path saveFolder;
    Path charFile;
    Path totalPath;
    Actor currentActor;
    private final ObjectMapper mapper = new ObjectMapper();

    private WriteReadCharacter(Path saveFolder){
        this.saveFolder = saveFolder;
    }

    private WriteReadCharacter(Path saveFolder, Actor currentActor){
        this(saveFolder);
        this.currentActor = currentActor;
        this.charFile = Paths.get(String.format("%1$s.json",currentActor.getName()));
        this.totalPath = saveFolder.resolve(charFile);
    }

    public void packActor(Actor userChar, Path saveLocation){
        Path charFile = Paths.get(String.format("%1$s.json",userChar.getName()));
        try(OutputStream outputStream = new FileOutputStream(saveLocation.resolve(charFile).toString())){
            mapper.writeValue(outputStream, userChar);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public Actor unpackActor(){
        try(InputStream inputStream = new FileInputStream(saveFolder.resolve(charFile).toString())){
            return mapper.readValue(inputStream, Actor.class);
        }catch(Exception exception){
            exception.printStackTrace();
            return null;
        }
    }
}
