import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can i do for you?");
        Scanner userInput = new Scanner(System.in);
        String userCommand;
        while(true){
            userCommand= userInput.nextLine();
            System.out.println("    -------------------------");
            matchCommand(userCommand);
            System.out.println("    -------------------------");
            if(userCommand.equals("bye")){
                System.exit(1);
            }
        }
    }

    public static void matchCommand(String userCommand) {

        switch (userCommand) {
        case "list":
            Task.printList();
            break;
        case "blah":
            System.out.println("    blah");
            break;
        case "bye":
            System.out.println("     Bye. Hope to see you again soon!");
            break;
        default:
            new Task(userCommand);
            System.out.println("     added: " + userCommand);
            break;
        }
    }
}

class Task {
    protected String description;
    protected boolean isDone;
    static ArrayList<Task> list = new ArrayList<>(); //class level member

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        list.add(this);
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String getDescription() {
        return description;
    }

    public static void printList() {
        int i =1;
        for(Task t : list){
            System.out.println("     "+i+". " + t.getDescription());
            i++;
        }
    }
}
