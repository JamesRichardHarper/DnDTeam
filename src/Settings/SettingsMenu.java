package Settings;

import java.io.*;
import java.util.Properties;

public class SettingsMenu {
        private static final String PROPERTIES_FILE = "Settings.properties";
        private Properties properties;

        public SettingsMenu(){
                properties = new Properties();
                loadProperties();
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
