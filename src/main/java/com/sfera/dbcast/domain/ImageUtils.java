package com.sfera.dbcast.domain;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class ImageUtils {

    public static final String IMAGE_LOCATION_URL = "http://localhost:8080/img/";
    private static final String TARGET_STATIC_FOLDER_URL = "target/classes/static/";
    private static final String STATIC_FOLDER_URL = "src/main/resources/static/";

    public static String getImageName(MultipartFile image, String namePattern){

        final String fileExtension = Optional.ofNullable(image.getOriginalFilename())
                .flatMap(ImageUtils::getFileExtension)
                .orElse("");

        return namePattern + "." + fileExtension;
    }

    private static Optional<String> getFileExtension(String fileName) {
        final int indexOfLastDot = fileName.lastIndexOf('.');

        if (indexOfLastDot == -1) {
            return Optional.empty();
        } else {
            return Optional.of(fileName.substring(indexOfLastDot + 1));
        }
    }

    public static void storeImageStaticFolder(String fileName, MultipartFile image) throws IOException{
        storeImage(STATIC_FOLDER_URL, fileName, image);
    }

    public static void storeImageTargetFolder(String fileName, MultipartFile image) throws IOException{
        storeImage(TARGET_STATIC_FOLDER_URL, fileName, image);
    }

    private static void storeImage(String pathName, String fileName, MultipartFile file) throws IOException {

        String fileLocation = new File(pathName).getPath() + "/" + fileName;

        try(InputStream in = file.getInputStream()){
            try(OutputStream out = new FileOutputStream(fileLocation)){
                copy(in, out);
            }
        }
    }

    public static void deleteImage(String storedImageName){
        Path staticFolderPath = Paths.get(STATIC_FOLDER_URL + storedImageName);
        Path targetFolderPath = Paths.get(TARGET_STATIC_FOLDER_URL + storedImageName);
        try {
            Files.delete(staticFolderPath);
            Files.delete(targetFolderPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(InputStream source, OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) > 0) {
            target.write(buf, 0, length);
        }
    }
}
