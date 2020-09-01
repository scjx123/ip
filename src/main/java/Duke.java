import java.util.*;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        //Greets user and exit
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can i do for you?");
        Scanner sc = new Scanner(System.in);
        String command;
        while(true){
            command = sc.nextLine();
            System.out.println("-------------------------");
            user_command(command);
            System.out.println("-------------------------");
            if(command.equals("bye")){
                System.exit(1);
            }
        }
    }
    public enum taskType{
        TODO,
        DEADLINE,
        EVENT
    }
    public static void user_command(String command) {
        StringTokenizer st=new StringTokenizer(command);
        String tokenHolder = st.nextToken();
        int dividerPosition = 0;
        int whitespacePosition = 0;
        String dateTime = "";

        if(command.contains("/")){
            dividerPosition = command.indexOf('/');
            whitespacePosition = command.indexOf(' ');
            dateTime=command.substring(dividerPosition+1);
            command=command.substring(whitespacePosition,dividerPosition);
        }

        switch (tokenHolder) {
        case "list": {
            Task.printList();
        } break;
        case "done": {
            System.out.println("    Nice! I've marked this task as done:");
            int itemNum = Integer.parseInt(st.nextToken())-1;

            if(Task.itemExist(itemNum)) {  //First validate if item exist in list
                Task.completed(itemNum); //if yes, then we call the completed function.
            }
        } break;
        case "bye": {
            System.out.println("    Bye. Hope to see you again soon!");
        }break;
        default: {
            if(tokenHolder.equals("todo")) {
                new Task(command, taskType.TODO,dateTime);
            }else if(tokenHolder.equals("deadline")){
                new Task(command, taskType.DEADLINE,dateTime);
            }else if(tokenHolder.equals("event")){
                new Task(command, taskType.EVENT,dateTime);
            }
            Task.printTask();
        }break;
        }
    }
}

class Task {

    protected String description;
    protected boolean isDone;
    protected Duke.taskType type;
    String dateTime="";
    static ArrayList<Task> list = new ArrayList<>(); //class level member

    public Task(String description,Duke.taskType type,String dateTime) {
        this.description = description;
        this.isDone = false;
        this.type=type;
        if(!dateTime.isEmpty()) {
            this.dateTime = "(" + dateTime + ")";
        }
        list.add(this);
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String getDescription() {
        return description;
    }
    public char getType() {
        char taskTypetoLetter='X';
        switch(type){
        case TODO:{
            taskTypetoLetter='T';
        }break;
        case DEADLINE:{
            taskTypetoLetter='D';
        }break;
        case EVENT:{
            taskTypetoLetter='E';
        }break;
        default:
            break;
        }
        return taskTypetoLetter;
    }

    public static boolean itemExist(int num){
        return list.get(num) != null;
    }
    public static void completed(int num){
        list.get(num).isDone=true;
        System.out.println("    ["+list.get(num).getStatusIcon()+"]" + list.get(num).getDescription());
    }
    public static void printList(){
        int i =1;
        System.out.println("    Here are the task in your list:");
        for(Task t : list){
            System.out.println("    "+i+".["+t.getType()+"]["+t.getStatusIcon()+"]" + t.getDescription()+t.dateTime);
            i++;
        }
    }
    public static void printTask(){
        Task t= list.get(list.size()-1); //last item on the list.
        System.out.println("    Got it. I've added this task:");
        System.out.println("      ["+t.getType()+"]["+t.getStatusIcon()+"]"
                + t.getDescription()+t.dateTime);
        System.out.println("    Now you have "+list.size()+" task in the list");

    }
}
