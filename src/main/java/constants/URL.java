package constants;

import java.util.Objects;

import static support.Configuration.environment;

public class URL {
    private static String BASE_URL;
    public static String BASE_URL(){
        if(Objects.equals(environment(), "tst")){
            BASE_URL = "http://api.weatherapi.com";
        }else if(Objects.equals(environment(), "dev")){
            BASE_URL = "http://api.weatherapi.com";
        }
        return BASE_URL;
    }
}
