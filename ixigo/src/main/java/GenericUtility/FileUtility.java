package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

    public String getPropertyKeyValue(String key) throws IOException {

        FileInputStream fis = new FileInputStream("src/main/resources/CommonDataProperties.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String value = prop.getProperty(key);
        fis.close();

        return value;
    }
}