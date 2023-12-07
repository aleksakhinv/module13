import model.*;
import service.TaskHttpService;

import java.io.IOException;
import java.util.List;

public class TaskHttpDemo {
    public static void main(String[] args) throws IOException, InterruptedException {

        TaskHttpService taskHttpService = new TaskHttpService();

        System.out.println("--- Print all Tasks by UserId ---");
        Task[] allTasks = taskHttpService.getAllTaskByUserId(1);
        for(Task t : allTasks) {
            System.out.println(t);
        }
        System.out.println();

        System.out.println("--- Print all open Tasks ---");
        List<Task> allOpenTasks = taskHttpService.getOpenTasks(allTasks);
        for(Task t : allOpenTasks) {
            System.out.println(t);
        }



    }
}
