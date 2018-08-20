package org.prezydium.cvmachine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.prezydium.cvmachine.model.CVModel;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;

@RestController
public class FileDownloader {

    private final ObjectMapper objectMapper;

    public FileDownloader(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RequestMapping(name = "/save", method = RequestMethod.GET)
    public ResponseEntity getSerializedCv(HttpSession httpSession) throws JsonProcessingException {

        CVModel cvModel = (CVModel) httpSession.getAttribute("cvModel");

        byte[] buf = objectMapper.writeValueAsBytes(cvModel);
        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"cv.json\"")
                .contentLength(buf.length)
                .contentType(
                        MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(new ByteArrayInputStream(buf)));
    }


}
