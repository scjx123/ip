package duke.task;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Task {
    static ArrayList<Task> list = new ArrayList<>();
    protected String description;
    protected boolean isDone;
    protected char type;
    String dateTime = "";

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        list.add(this);
    }

    public static void loadData(List<String> lineArray) {

        for (String str : lineArray) {
            if(str!=null) {
                String[] loadedTask = str.split(" ",3);

                System.out.println(loadedTask[0]);
                System.out.println(loadedTask[1]);
                System.out.println(loadedTask[2]);
                //System.out.println(loadedTask[3]);
                String commandDescription;
                int index=0;
                if(loadedTask[2].contains("/")) {
                    index = loadedTask[2].indexOf("/");
                    commandDescription = loadedTask[2].substring(0, index);
                }else {
                    commandDescription = loadedTask[2];
                }
                String loadedDateTime = loadedTask[2].substring(index + 1);

                switch (loadedTask[0]) {
                case "T":
                    //creating a new object which automatically adds to the list.
                    Todo object_T = new Todo(commandDescription);
                    markAsDone(object_T, loadedTask[1].equals("true"));
                    break;
                case "D":
                    Event object_D = new Event(commandDescription, loadedDateTime);
                    markAsDone(object_D, loadedTask[1].equals("true"));
                    break;
                case "E":
                    Deadline object_E = new Deadline(commandDescription, loadedDateTime);
                    markAsDone(object_E, loadedTask[1].equals("true"));
                    break;
                default:
                    break;
                }
            }
        }

    }

    public static void removeItem(int num) {
        Task t = list.get(num);
        System.out.println("     Got it. I've removed this task:");
        System.out.println("       " + t.toString());
        list.remove(t);
        System.out.println("     Now you have " + list.size() + " task in the list.");
    }

    public static boolean itemExist(int num) {
        return list.get(num) != null;
    }

    public static void markAsDone(Task task, boolean logic) {
        task.isDone = logic;
    }

    public static void markAsDone(int num) {
        list.get(num).isDone = true;
        System.out.println("    " + list.get(num).toString());
    }

    public static ArrayList<Task> getList() {
        return list;
    }

    public static void printList() {
        int i = 1;
        System.out.println("     Here are the task in your list:");
        for (Task t : list) {
            System.out.println("     " + i + "." + t.toString());
            i++;
        }
    }

    public static void printTask() {
        //Retrieve the last item on the list.
        Task t = list.get(list.size() - 1);
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + t.toString());
        System.out.println("     Now you have " + list.size() + " task in the list.");
    }

    @Override
    public String toString() {
        return ("[" + getStatusIcon() + "]" + getDescription());
    }

    public String getStatusIcon() {
        return (isDone ? "Completed" : "Uncompleted");
    }

    public String getDescription() {
        return description;
    }

    public char getType() {
        return type;
    }

    public String getDateTime() {
        return dateTime;
    }

}
