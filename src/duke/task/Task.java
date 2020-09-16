package duke.task;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    String dateTime="";
    static ArrayList<Task> list = new ArrayList<>();
    public static void loadData(List<String> lineArray){
        for(String str : lineArray ) {
            String[] loadedTask = str.split(" ", 3);
            String loadedCommand;
            int index = loadedTask[2].indexOf("/");
            loadedCommand = loadedTask[2].substring(0, index);
            String loadedDateTime = loadedTask[2].substring(index + 1);

            switch (loadedTask[0]) {
            case "T":
                //creating a new object which automatically adds to the list.
                duke.task.Todo object_T = new duke.task.Todo(loadedCommand);
                duke.task.Task.markAsDone(object_T, loadedTask[1].equals("true"));
                break;
            case "D":
                duke.task.Event object_D = new duke.task.Event(loadedCommand, loadedDateTime);
                duke.task.Task.markAsDone(object_D, loadedTask[1].equals("true"));
                break;
            case "E":
                duke.task.Deadline object_E = new duke.task.Deadline(loadedCommand, loadedDateTime);
                duke.task.Task.markAsDone(object_E, loadedTask[1].equals("true"));
                break;
            default:
                break;
            }
        }
    }


    public Task(String description) {
        this.description = description;
        this.isDone = false;
        list.add(this);
    }

    @Override
    public String toString() {
        return ("["+getStatusIcon()+"]" +getDescription());
    }

    public String getStatusIcon() {
        return (isDone ? "Done" : "Not done");
    }
    public String getDescription() {
        return description;
    }
    public static void removeItem(int num) {
        Task t = list.get(num);
        System.out.println("     Got it. I've removed this task:");
        System.out.println("       " + t.toString());
        list.remove(t);
        System.out.println("     Now you have " + list.size() + " task in the list.");
    }
    public char getType(){
        return type;
    }
    public String getDateTime(){
        return dateTime;
    }
    public static boolean itemExist(int num) {
        return list.get(num) != null;
    }
    public static void markAsDone(Task task,boolean logic){
        task.isDone=logic;
    }
    public static void markAsDone(int num) {
        list.get(num).isDone=true;
        System.out.println("    "+list.get(num).toString());
    }
    public static ArrayList<Task> getList(){
        return list;
    }
    /*public static void find(String userKeyword){
        //Example find 'book'
        int i =1;
        for(Task t : list){
            if(t.getDescription().contains(userKeyword)){
                System.out.println("     "+i+"."+t.toString());
                i++;
            }
        }
    }*/
    public static void printList() {
        int i =1;
        System.out.println("     Here are the task in your list:");
        for(Task t : list) {
            System.out.println("     "+i+"."+t.toString());
            i++;
        }
    }
    public static void printTask() {
        //Retrieve the last item on the list.
        Task t = list.get(list.size()-1);
        System.out.println("     Got it. I've added this task:");
        System.out.println("       "+t.toString());
        System.out.println("     Now you have "+list.size()+" task in the list.");
    }

}
