import duke.task.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    //get home directory
    static String home = System.getProperty("user.home");
    static String filePath;
    static String[] dir=new String[2];
    private static String filename = "tasks.txt";
    private static String filedir = "data";
    private static Object Task;

    public Storage(String filePath){
        //Path indicated by user;
        dir=filePath.split("/",2);
        filename=dir[1];
        filedir=dir[0];
    }

    //create a path
    static Path p1 = Paths.get(home, filedir);
    static Path p2 = Paths.get(home, filedir, filename);
    /**
     * loadedTask[0] indicates the type of task.
     * loadedTask[1] indicates done or not done.
     * loadedTask[2] indicates the task description.
     */
    public static List<String> load() throws IOException {
        if (!Files.exists(p2)) {
            Files.createFile(p2);
        }

        return Files.readAllLines(p2);

    }
    public static void writeFile(ArrayList<Task> list) throws IOException {

        FileWriter fw = new FileWriter(p2.toString());
        //String[] s= new String[list.size()];
        //Writing Data to specified filePath
        for(Task t : list) {
            fw.write(t.getType() + " " + t.getStatusIcon() + " " + t.getDescription() + " " + "/" + t.getDateTime().replaceFirst(":", "") + '\n');
        }
        fw.close();
    }

}
