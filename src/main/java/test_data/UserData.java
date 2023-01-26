package test_data;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import support.Configuration;
import support.Json;
import support.Print;

import static support.Utils.trimDoubleQuotation;

public class UserData {
    private static final Logger log = LogManager.getLogger();

    public UserData(){}

    private JsonNode userDetailsInJsonFormat;

    public UserData accountType(String accountType){
        JsonNode node;
        JsonNode userDetails = null;

        try{
            node = Json.readFile(Configuration.userDataDir("test_accounts_dev.json"));
            for(JsonNode user : node){
                if(user.get("account_type").toString().equals("\""+accountType+"\"")){
                    userDetails = user;
                }
            }
        }catch(Exception e){
            Print.errorMessage("Error generated from UserData.accountType()\n" + e.getMessage());
        }

        if(userDetails == null)
            Print.errorMessage("User details is null. Generated from UserData.accountType()");

        userDetailsInJsonFormat = userDetails;

        return this;
    }

    public String get(String fieldName){
        String returnValue = String.valueOf(userDetailsInJsonFormat.get(fieldName));
        return trimDoubleQuotation(returnValue);
    }
}
