package support;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.apache.commons.io.IOUtils;



public abstract class Json {

    /** readFile() - reads json data from .json file and returns the value in JSON format */
    public static JsonNode readFile(String sourceFile){
        FileInputStream fis;
        String jsonData;
        ObjectMapper objectMapper;
        JsonNode jsonNode = null;

        try{
            fis = new FileInputStream(sourceFile);
            jsonData = IOUtils.toString(fis, StandardCharsets.UTF_8);
            objectMapper = new ObjectMapper();
            jsonNode = objectMapper.readTree(jsonData);
        }catch (Exception e){
            Print.errorMessage(e.getMessage());
        }

        return Objects.requireNonNull(jsonNode);
    }

    public static JsonNode read(String jsonString) {
        ObjectMapper objectMapper;
        JsonNode jsonNode = null;
        String jsonData;

        try{
            jsonData = jsonString;
            objectMapper = new ObjectMapper();
            jsonNode = objectMapper.readTree(jsonData);
        }catch (Exception e){
            Print.errorMessage(e.getMessage());
        }

        return jsonNode;
    }
}