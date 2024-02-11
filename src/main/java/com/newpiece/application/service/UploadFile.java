package com.newpiece.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    private final String FOLDER = "images//";
    private final String IMG_DEFAULT = "default.jpg";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()){
            byte [] bytes = multipartFile.getBytes();
            Path path = Paths.get(FOLDER + multipartFile.getOriginalFilename());
            Files.write(path ,bytes);
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    public void delete(String nameFile){
        File file = new File(FOLDER + nameFile);
        file.delete();
    }

}