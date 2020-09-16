import duke.task.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    //get home directory
    static String home = System.getProperty("user.home");

    public Storage(String filePath){
        //Path indicated by user
        Path p2 = Paths.get(home,"Downloads",filePath);
    }

    //create a path
    static Path p1 = Paths.get(home, "Downloads");
    static String fileName = "line.txt";
    static Path p2 = Paths.get(home, "Downloads", fileName);

    /**
     * loadedTask[0] indicates the type of task.
     * loadedTask[1] indicates done or not done.
     * loadedTask[2] indicates the task description.
     */
    public static List<String> load() throws IOException {
        if (!Files.exists(p2)) {
            Files.createFile(p2);
        }

        List<String> lineArray = Files.readAllLines(p2);
        return lineArray;
    }
    public static void writeFile(ArrayList<Task> list) throws IOException {

        FileWriter fw = new FileWriter(p2.getFileName().toString());

        //Writing Data to specified filePath
        for(Task t : list)
            fw.write(t.getType() + " "+ t.getStatusIcon() + " " + t.getDescription() + " "+"/" + t.getDateTime().replaceFirst(":","") + '\n');
        fw.close();
    }

}
