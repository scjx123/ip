package duke.task;

import java.nio.file.Path;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;

public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    String dateTime = "";
    static ArrayList<Task> list = new ArrayList<>();

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
    public static void writeFile(Path p2) throws IOException {

        FileWriter fw = new FileWriter(p2.getFileName().toString());

        //Writing Data to specified filePath
        for(Task t : list)
            fw.write(t.getType() + " "+ t.isDone + " " + t.getDescription() + " "+"/" + t.getDateTime().replaceFirst(":","") + '\n');
        fw.close();
    }
}
