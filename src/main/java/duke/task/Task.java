package duke.task;

import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
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
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String getDescription() {
        return description;
    }

    public static boolean itemExist(int num) {
        return list.get(num) != null;
    }
    public static void markAsDone(int num) {
        list.get(num).isDone=true;
        System.out.println("    ["+list.get(num).getStatusIcon()+"]" + list.get(num).getDescription());
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
        //retrieve the last item on the list.
        Task t = list.get(list.size()-1);
        System.out.println("     Got it. I've added this task:");
        System.out.println("       "+t.toString());
        System.out.println("     Now you have "+list.size()+" task in the list.");

    }
}
