package seedu;

import seedu.task.Task;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.util.Scanner;

public class Storage {
    /** Get home directory of the user's operating system. */
    private static String home = System.getProperty("user.home");
    /** Temporary stores the file directory and the name of the text file itself given in the filePath. */
    private static String[] dir = new String[2];
    private static String filename = "tasks.txt";
    private static String filedir = "data";

    /**
     * Splits the filePath variable into file directory and file name.
     *
     * @param filePath an absolute path of the text file that stores user data.
     */
    public Storage(String filePath) {
        dir = filePath.split("/",2);
        filename = dir[1];
        filedir = dir[0];
    }

    /** Create a path p2. */
    static Path p2 = Paths.get(home + File.separator + filedir + File.separator + filename);
    static Path p1 = Paths.get(filename);
    static Path filePath = Paths.get(filedir,filename);
    static Path fileDirectory = Paths.get(filedir);

    private static String OS = System.getProperty("os.name").toLowerCase();
    static File file = new File(filename);

    /**
     * Checks if the filePath stated by user exist.
     * If it does not exist, this method will create a new filePath accordingly.
     * It will then proceed to read the text file, which can be either empty
     * or has existing data in it.
     *
     * @return <String></String>return list
     * @throws IOException Thrown by the input/reading operation.
     */
    public static List<String> load() throws IOException {
        List<String> dataList = null;
        if (OS.contains("mac")) {
            if (!Files.exists(p2)) {
                file.createNewFile();
            }

            dataList = Files.readAllLines(p1);

        } else {
            if (!Files.exists(fileDirectory)) {
                Files.createDirectory(fileDirectory);
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            dataList = Files.readAllLines(filePath);
        }
        return dataList;
    }

    /**
     * Iterates through the current task objects stored in the list, and writes them
     * to the filePath specified by the user.
     *
     * @param list that stores all the current Task object.
     * @throws IOException Thrown by the writing operation.
     */
    public static void writeFile(ArrayList<Task> list) throws IOException {

        if (OS.contains("mac")) {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (list.isEmpty()) {
                bufferedWriter.close();
            } else {
                for (Task t : list) {
                    bufferedWriter.write(t.getType() + " " + t.getStatusIcon() + " " + t.getDescription() + " "
                            + CommandParser.originalDateTime + '\n');
                }
                bufferedWriter.close();
            }
        } else {
            FileWriter fw = new FileWriter(filePath.toString());
            for (Task t : list) {
                fw.write(t.getType() + " " + t.getStatusIcon() + " " + t.getDescription() + " "
                        + CommandParser.originalDateTime + '\n');
            }
            fw.close();
        }
    }
}
