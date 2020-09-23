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

    /**
     * Constructs a new Task object while initiating description, isDone
     * and add the new Task object to the ArrayList list.
     *
     * @param description Description of the task specified by user.
     */

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        list.add(this);
    }


    /**
     * Creates task given in the lineArray based on their types T,D or E.
     *
     * @param lineArray Contains all previous task (in String) from the text file
     *                  who's file path is specified by the user.
     */
    public static void loadData(List<String> lineArray) {

        for (String str : lineArray) {
            if(str!=null) {
                String[] loadedTask = str.split(" ",3);
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

    /**
     * Removes an item on the list.
     *
     * @param num
     */
    public static void removeItem(int num) {
        Task t = list.get(num);
        System.out.println("     Got it. I've removed this task:");
        System.out.println("       " + t.toString());
        list.remove(t);
        System.out.println("     Now you have " + list.size() + " task in the list.");
    }

    /**
     * Check if an item exist on the list.
     * Returns true if item exist, and false if it does not exist.
     *
     * @param num the Index of the item on the list.
     * @return true or false based on whether item exist in the list.
     */
    public static boolean itemExist(int num) {
        return list.get(num) != null;
    }

    /**
     * Mark a Task as completed when provided with a logic.
     * Used mainly for loading in previous data from text file.
     *
     * @param task The task object that is being mark as done.
     * @param logic The task completion status (true or false).
     *              true : Completed.
     *              false: Uncompleted.
     */
    public static void markAsDone(Task task, boolean logic) {
        task.isDone = logic;
    }

    /**
     * Mark a Task as completed when provided with an index on the list.
     *
     * @param num The index of the task on the list.
     */
    public static void markAsDone(int num) {
        list.get(num).isDone = true;
        System.out.println("    " + list.get(num).toString());
    }

    /**
     * Returns the entire list object.
     *
     * @return list The entire current ArrayList list object.
     */
    public static ArrayList<Task> getList() {
        return list;
    }

    /**
     * Search through the entire list for task with description that matches the userKeyword
     *
     * @param userKeyword
     */
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
    /**
     * Iterates through the entire list object and prints each one out.
     */
    public static void printList() {
        int i = 1;
        System.out.println("     Here are the task in your list:");
        for (Task t : list) {
            System.out.println("     " + i + "." + t.toString());
            i++;
        }
    }

    /**
     * Prints description of a single task object that is being added to the list.
     */
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

    /**
     * Returns the status icon of the "Completed" or "Uncompleted".
     *
     * @return isDone Completed or Uncompleted status of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "Completed" : "Uncompleted");
    }

    /**
     * Returns the description of the task.
     *
     * @return description  Description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns commandType data type of the event. Mostly used for writing to text file.
     *
     * @return commandType data type of the event.
     */
    public commandType getType() {
        return type;
    }

    /**
     * Returns the date and time of the object stated by user.
     *
     * @return dateTime Date and Time of the object.
     */
    public String getDateTime() {
        return dateTime;
    }

}
