package org.prezydium.cvmachine.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUploaderService {

    public File processUpload(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        File file = File.createTempFile("tempcv", "json");
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(buffer);
        return file;
    }
}
