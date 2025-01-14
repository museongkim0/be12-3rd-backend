package utils;

import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadUtil {
    private final static String uploadPath = "C:/Users/ms0/Desktop/backend/java실습/day06/web/static/upload/";
    public static List<String> upload(List<Part> imageList) {
        List <String> pathList = new ArrayList<String>();
        try {
            for (Part part : imageList) {
                part.write(uploadPath + part.getSubmittedFileName());
                pathList.add("/static/upload/" + part.getSubmittedFileName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pathList;
    }
}
