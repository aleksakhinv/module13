package service;

import com.google.gson.Gson;
import model.Comment;
import model.Post;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Comparator;

public class CommentHttpService {
    private static String POST_URL = "https://jsonplaceholder.typicode.com/posts/";
    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();

    public Comment[] getAllCommentsByPostId (int postId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POST_URL + postId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), Comment[].class);
    }

    public Integer getLastPostId (int userId) throws IOException, InterruptedException {
        Post[] allPosts = getAllPostsByUserId(userId);
        return Arrays.asList(allPosts).stream()
                .map(Post::getId)
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    public Post[] getAllPostsByUserId (int userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USER_URL + "/" + userId + "/posts"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), Post[].class);


    }
}
