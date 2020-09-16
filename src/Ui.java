import duke.DukeException.InsufficientArgumentException;
import duke.DukeException.InvalidCommandException;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ui {

    public static String readCommand() {
        String userCommand;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();
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

    public static void showError(String errorMessage){
        System.out.println(errorMessage);
    }
}
