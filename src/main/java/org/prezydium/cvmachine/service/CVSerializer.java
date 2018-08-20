package org.prezydium.cvmachine.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.prezydium.cvmachine.model.CVModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CVSerializer {

    private Logger logger = LoggerFactory.getLogger(CVSerializer.class);

    private final ObjectMapper objectMapper;

    public CVSerializer() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }


    public void serializeCVModelToXMLFile(CVModel cvModel, String path, String fileName) {
        try {
            objectMapper.writeValue(new File(new StringBuilder()
                    .append(path)
                    .append("/")
                    .append(fileName)
                    .append(".json")
                    .toString()
            ), cvModel);
        } catch (IOException e) {
            logger.error("Error while writing CV to file: " + e.getMessage());
        }
    }

    public CVModel deserializeFromXMLToCVModel(String path) {
        File file = new File(path);
        String jsonString = "";
        CVModel cvModel = new CVModel();
        try {
            jsonString = inputStreamToString(new FileInputStream(file));
            cvModel = objectMapper.readValue(jsonString, CVModel.class);
        } catch (IOException e) {
            logger.error("Error while reading CV from file: " + e.getMessage());
        }
        return cvModel;

    }

    private String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}