package org.prezydium.cvmachine.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.prezydium.cvmachine.model.CVModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CVSerializer {

    Logger logger = LoggerFactory.getLogger(CVSerializer.class);

    public void serializeCVModelToXMLFile(CVModel cvModel, String path, String fileName) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(new StringBuilder()
                    .append(path)
                    .append("/")
                    .append(fileName)
                    .append(".xml")
                    .toString()
            ), cvModel);
        } catch (IOException e) {
            logger.error("Error while writing CV to file: " + e.getMessage());
        }
    }

    public CVModel deserializeFromXMLToCVModel(String path) {
        File file = new File(path);
        XmlMapper xmlMapper = new XmlMapper();
        String xml;
        CVModel cvModel = new CVModel();
        try {
            xml = inputStreamToString(new FileInputStream(file));
            cvModel = xmlMapper.readValue(xml, CVModel.class);
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