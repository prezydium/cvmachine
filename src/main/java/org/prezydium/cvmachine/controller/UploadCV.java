package org.prezydium.cvmachine.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.prezydium.cvmachine.model.CVModel;
import org.prezydium.cvmachine.service.FileUploaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(UploadCV.class);

    public UploadCV(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping(path = "/upload", method = RequestMethod.GET)
    public ModelAndView uploadForm() {
        return new ModelAndView("upload");
    }

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public RedirectView handleFile(@RequestParam("file") MultipartFile mfile, HttpSession httpSession) {
        try {
            CVModel cvModel = objectMapper.readValue(new FileUploaderService().processUpload(mfile), CVModel.class);
            httpSession.setAttribute("cvModel", cvModel);
            return new RedirectView("/");
        } catch (IOException e) {
            logger.error("error loading cv: " + e.getMessage());
        }
        return new RedirectView("/");
    }
}
