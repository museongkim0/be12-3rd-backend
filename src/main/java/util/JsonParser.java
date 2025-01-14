package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

public class JsonParser {
    private static final StringBuilder jsonBuilder = new StringBuilder();
    private static final ObjectMapper mapper = new ObjectMapper();


    public static String parse(HttpServletRequest req) {
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String json = jsonBuilder.toString();

        return json;
    }

    public static <T> T parse(HttpServletRequest req, Class<T> c) {
        T dto = null;
        try (BufferedReader reader = req.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
            String json = jsonBuilder.toString();

            dto = mapper.readValue(json, c);

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    public static <T> void parse(HttpServletResponse resp, T dto) {
        try {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            mapper.writeValue(resp.getWriter(), dto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
