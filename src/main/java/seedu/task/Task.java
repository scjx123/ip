package seedu.task;

import seedu.Ui;

import java.util.ArrayList;

public class Task {
    static ArrayList<Task> list = new ArrayList<>();
    protected String description;
    protected boolean isDone;
    protected CommandType type;
    String dateTime = "";

    public enum CommandType {
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
     * Removes an item on the list.
     *
     * @param num The index of the task on the list.
     */
    public static void removeItem(int num) {
        Task t = list.get(num);
        Ui.taskIO("delete",t,list.size() - 1);
        list.remove(t);
    }

    /**
     * Check if an item exist on the list.
     * Returns true if item exist, and false if it does not exist.
     *
     * @param num The index of the task on the list.
     * @return Logical true or false based on whether item exist in the list.
     */
    public static boolean itemExist(int num) {
        return list.get(num) != null;
    }

    /**
     * Mark a Task based on the logic it is provided with.
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
        Task t = list.get(num);
        t.isDone = true;
        Ui.taskIO("done",t,list.size());
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
     * Search through the entire list for task with description that matches the userKeyword.
     *
     * @param userKeyword A String keyword that the user wish to search in the list.
     */
    public static void find(String userKeyword) {
        //Example find 'book'
        int i = 1;
        for (Task t : list) {
            if (t.getDescription().contains(userKeyword)) {
                Ui.taskIO("find",t,i);
                i++;
            }
        }
    }
    /**
     * Iterates through the entire list object and prints each one out.
     *
     */

    public static void printList() {
        int i = 1;
        Ui.taskIO("listHeader",null,-1);
        for (Task t : list) {
            Ui.taskIO("list", t, i);
            i++;
        }
    }

    /**
     * Prints description of a single task object that is being added to the list.
     *
     */
    public static void printTask() {
        //Retrieve the last item on the list.
        Task t = list.get(list.size() - 1);
        Ui.taskIO("task",t,list.size());
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
     * @return description Description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns commandType data type of the event. Mostly used for writing to text file.
     *
     * @return commandType Data type of the event.
     */
    public CommandType getType() {
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
