package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Comment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {
    public void writeToFile(Comment[] comments, String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(comments);

        File fileTo = new File("src/main/resources/" + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileTo))) {
            writer.write(jsonString);
            System.out.println("File successfully written");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
