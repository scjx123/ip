
import duke.DukeException.InvalidCommandException;

import java.util.Scanner;

public class Ui {

    public static String readCommand() throws InvalidCommandException {
        String userCommand;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();
        if(userCommand==null){
            throw new InvalidCommandException();
        }
        return userCommand;
    }

    public static void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can i do for you?");
    }

    public static void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public static void showLoadingError(){
        System.out.println("Unable to load file.");
    }

    public static void showError(String error){
        switch(error){
        case "iae":

            System.out.println("     OPPS!!! Description cannot be empty.");
            break;
        case "ie":
            System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
            break;
        case "ne":
            System.out.println("     OOPS!!! I'm sorry, but that is an invalid command :-(");
            break;
        case "iobe":
            System.out.println("     OOPS!!! I'm sorry, task does not exist in the list :-(");
            break;
        case "e":
            System.out.println("     Unable to write.");
            break;
        case "nfe":
            System.out.println("     OOPS!!! That is an invalid format!");
        default:
            break;
        }

    }
}
