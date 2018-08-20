package org.prezydium.cvmachine.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.prezydium.cvmachine.model.CVModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class UploadCV {

    private final ObjectMapper objectMapper;

    public UploadCV() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JSR310Module());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadForm() {
        return new ModelAndView("upload");
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public RedirectView handleFile(@RequestParam("file") MultipartFile mfile, HttpSession httpSession) throws IOException {
        InputStream inputStream = mfile.getInputStream();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        File file = File.createTempFile("tempcv", "json");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(buffer);
        JsonNode jsonNode = objectMapper.readTree(file);
        CVModel cvModel = objectMapper.readValue(file, CVModel.class);
        httpSession.setAttribute("cvModel", cvModel);
        return new RedirectView("/");
    }
}
