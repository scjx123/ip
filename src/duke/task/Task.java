package duke.task;

import java.util.ArrayList;
import java.util.List;

public class Task {
    static ArrayList<Task> list = new ArrayList<>();
    protected String description;
    protected boolean isDone;
    protected commandType type;
    String dateTime = "";

    public enum commandType {
        T, D, E
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        list.add(this);
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

    public static void find(String userKeyword){
        //Example find 'book'
        int i =1;
        for(Task t : list){
            if(t.getDescription().contains(userKeyword)){
                System.out.println("     "+i+"."+t.toString());
                i++;
            }
        }
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

    public commandType getType() {
        return type;
    }

    public String getDateTime() {
        return dateTime;
    }

}
