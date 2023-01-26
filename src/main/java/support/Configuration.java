package support;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class Configuration {
    /** loadConfiguration() - returns all configuration found in config folder with the extension .properties */
    private static Properties loadConfiguration(){
        Properties properties = new Properties();
        String path = System.getProperty("user.dir") + "/config";

        File folder = new File(path);
        File[] fileList = folder.listFiles();

        if(fileList == null || fileList.length == 0) {
            Print.errorMessage("Folder is missing or empty");
        }
        else {
            try {
                for (File file : fileList) {
                    properties.load(new FileInputStream(file));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return Objects.requireNonNull(properties);
    }


    /** environment() - returns the name of environment defined in .properties */
    public static String environment(){
        String environment = loadConfiguration().getProperty("environment");
        String env;

        if(environment == null)
            Print.errorMessage("Environment is null");

        if(Objects.equals(environment, "tst")) env = environment;
        else if(Objects.equals(environment, "dev")) env = environment;
        else throw new RuntimeException("Could not set test environment. Refer to Configuration.environment()");

        return env;
    }

    /**
     * userDataDir() - returns the json file directory located in project root 'data/user_data/**' directory
     * */
    public static String userDataDir(String filename){
        String dataDir = loadConfiguration().getProperty("root.data.user_data.dir");

        if(dataDir == null)
            Print.errorMessage("User Data directory is null");

        return System.getProperty("user.dir") + "/" + dataDir + "/" + filename;
    }

    public static String jsonSchemaDir(){
        String directory = loadConfiguration().getProperty("root.data.json_schema.dir");

        if(directory == null)
            Print.errorMessage("Json Schema directory is null");

        return System.getProperty("user.dir") + "/" + directory;
    }
}

