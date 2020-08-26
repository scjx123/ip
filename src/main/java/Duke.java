import java.util.Scanner;

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

    public static void matchCommand(String userCommand){
        switch (userCommand) {
        case "list": {
            System.out.println("    list");
        } break;
        case "blah": {
            System.out.println("    blah");
        } break;
        case "bye": {
            System.out.println("    Bye. Hope to see you again soon!");
        }break;
        default: {
        }break;
        }
    }
}

