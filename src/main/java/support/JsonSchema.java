package support;

import java.io.File;

public class JsonSchema {
    /**
     * UseCase -
     * schemaDir("test.java.schema.demo.schemaDemo") --> Will Return - test/java/schema/demo/schemaDemo.json
     */
    public static File schemaDir(String JsonFile){
        String convertedToNormalPath = JsonFile.replaceAll("\\.", "/");

        return new File(Configuration.jsonSchemaDir() + convertedToNormalPath + ".json");
    }
}
