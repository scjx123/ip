import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

        while(true) {
            userCommand = userInput.nextLine();
            System.out.println("    ____________________________________________________________");
            matchCommand(userCommand);
            System.out.println("    ____________________________________________________________");
            if(userCommand.equals("bye")) {
                System.exit(1);
            }
        }
    }
    public static void matchCommand(String userCommand) {
        StringTokenizer st = new StringTokenizer(userCommand);
        String tokenHolder = st.nextToken();
        int dividerPosition = 0;
        int whitespacePosition = 0;
        String dateTime = "";

        if(userCommand.contains("/")) {
            dividerPosition = userCommand.indexOf('/');
            whitespacePosition = userCommand.indexOf(' ');
            dateTime=userCommand.substring(dividerPosition+1);
            userCommand=userCommand.substring(whitespacePosition,dividerPosition);
        } else {
            if(st.hasMoreTokens()) {
                userCommand = userCommand.substring(userCommand.indexOf(' '));
            }
        }

        switch (tokenHolder) {
        case "list":
            Task.printList();
            break;
        case "done":
            System.out.println("     Nice! I've marked this task as done:");
            int itemNum = Integer.parseInt(st.nextToken())-1;

            if(Task.itemExist(itemNum)) {  //First validate if item exist in list
                Task.markAsDone(itemNum);   //if yes, then we call the completed function.
            }
            break;
        case "bye":
            System.out.println("     Bye. Hope to see you again soon!");
            break;
        default:
            if(tokenHolder.equals("todo")) {
                new todo(userCommand);
            }else if(tokenHolder.equals("deadline")) {
                new Deadline(userCommand,dateTime);
            }else if(tokenHolder.equals("event")) {
                new event(userCommand,dateTime);
            }
            Task.printTask();
            break;
        }
    }
}

class Task {
    protected String description;
    protected boolean isDone;
    String dateTime = "";
    static ArrayList<Task> list = new ArrayList<>(); //class level member

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
        Task t = list.get(list.size()-1); //last item on the list.
        System.out.println("     Got it. I've added this task:");
        System.out.println("       "+t.toString());
        System.out.println("     Now you have "+list.size()+" task in the list.");

    }
}

class todo extends Task {
    public todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
class Deadline extends Task {

    public Deadline(String description,String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = "(" + dateTime + ")";
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + dateTime ;
    }
}
class event extends Task {
    public event(String description,String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = "("+ dateTime +")" ;
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + dateTime ;
    }
}