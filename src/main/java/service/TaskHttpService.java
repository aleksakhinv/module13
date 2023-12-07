package service;

import com.google.gson.Gson;
import model.Task;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class TaskHttpService {
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public Task[] getAllTaskByUserId(int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_URL + "/" + userId + "/todos"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), Task[].class);
    }

    public List<Task> getOpenTasks(Task[] tasks) {
        return  Arrays.stream(tasks)
                .filter(task -> !task.isCompleted())
                .toList();
    }
}
