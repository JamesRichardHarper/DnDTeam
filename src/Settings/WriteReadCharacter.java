package Settings;

import CharacterClasses.Actor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteReadCharacter {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void packActor(Actor userChar, Path saveLocation){
        try(OutputStream outputStream = new FileOutputStream( getTotalPath(saveLocation, getCharFileName(userChar)) )){
            mapper.writeValue(outputStream, userChar);
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public static Actor unpackActor(String input){
        try(InputStream inputStream = new FileInputStream( input )){
            return mapper.readValue(inputStream, Actor.class);
        }catch(Exception exception){
            exception.printStackTrace();
            return null;
        }
    }

    public static Path getCharFileName(Actor userActor){
        return Paths.get(String.format("%1$s.json",userActor.getName()));
    }

    public static String getTotalPath(Path location, Path fileName){
        return location.resolve(fileName).toString();
    }
}
