package Settings;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SettingsMenu {
        FileSystem fileSystem = FileSystems.getDefault();
        private final String SETTINGS_NAME = "src\\Assets\\Settings.properties";
        private final Path ROOT_PATH = fileSystem.getPath("").toAbsolutePath();
        private final String PROPERTIES_FILE = String.format("%1$s/%2$s", ROOT_PATH,SETTINGS_NAME);
        private Properties properties;

        public SettingsMenu(){
                properties = new Properties();
                loadProperties();
                System.out.println(PROPERTIES_FILE);
        }

        private void loadProperties() {
                try(FileInputStream filePath = new FileInputStream(PROPERTIES_FILE)){
                        properties.load(filePath);
                } catch (IOException exception){
                        exception.printStackTrace();
                }
        }

        private void saveProperties(){
                try(FileOutputStream filePath = new FileOutputStream(PROPERTIES_FILE)){
                        properties.store(filePath, "Settings");
                } catch (IOException exception){
                        exception.printStackTrace();
                }
        }

        public String getSetting(String key){
                return properties.getProperty(key);
        }

        public void updateSetting(String key, String value){
                properties.setProperty(key, value);
                saveProperties();
        }
}
