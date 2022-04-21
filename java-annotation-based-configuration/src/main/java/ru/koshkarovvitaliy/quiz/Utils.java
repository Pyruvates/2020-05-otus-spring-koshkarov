package ru.koshkarovvitaliy.quiz;

import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;

public class Utils {
    static List<String> convertResourceToList(Resource res) throws IOException {
        if (res.contentLength() < 1) {
            System.out.println("The resource '" + res.getFilename() + "' is empty");
            return Collections.emptyList();
        }

        if (!res.exists() || !res.isReadable()) {
            System.out.println("The resource " + res.getFilename() + " does not exists or cannot be read");
            return Collections.emptyList();
        }

        File tempFile = Files.createTempFile("quizTemp", ".csv").toFile();

        try (InputStream inputStream = res.getInputStream();
             OutputStream outputStream = new FileOutputStream(tempFile)) {
            outputStream.write(inputStream.readAllBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tempFile.deleteOnExit();
        return Files.readAllLines(tempFile.toPath(), StandardCharsets.UTF_8);
    }
}
