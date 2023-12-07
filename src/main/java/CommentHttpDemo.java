import model.*;
import service.CommentHttpService;
import service.FileService;

import java.io.IOException;

public class CommentHttpDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        CommentHttpService commentHttpService = new CommentHttpService();

        System.out.println("--- Get Max PostId for UserId=1 ---");
        int userId = 1;
        Integer lastPostId = commentHttpService.getLastPostId(userId);
        Comment[] allCommentsByPostId = commentHttpService.getAllCommentsByPostId(lastPostId);
        System.out.println("Max user ID is " + lastPostId);
        System.out.println();

        System.out.println("--- Print all Comments for last User Post ---");
        for(Comment c : allCommentsByPostId) {
            System.out.println(c);
        }
        System.out.println();

        System.out.println("--- Write to File ---");
        FileService fileService = new FileService();
        String filename = "user-" + userId + "-post-" + lastPostId + "-comments.json";
        fileService.writeToFile(allCommentsByPostId, filename);

    }
}
