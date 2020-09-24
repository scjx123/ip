package seedu;

import seedu.dukeexception.InvalidCommandException;

import java.util.Scanner;

public class Ui {

    public Ui() {

    }
    /**
     * Returns string entered by user in the CLI.
     * If user presses enter without any command, seedu.DukeException.InvalidCommandException will be thrown.
     *
     * @return userCommand String command entered by the user.
     * @throws InvalidCommandException if userCommand is == null.
     */

    public static String readCommand() throws InvalidCommandException {
        String userCommand;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();
        if (userCommand == null) {
            throw new InvalidCommandException();
        }
        return userCommand;
    }

    /**
     * Shows the welcome text art of seedu.Duke.
     */
    public static void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    Hello! I'm seedu.Duke");
        System.out.println("    What can i do for you?");
    }

    /**
     * Prints out a line that allows CLI to demarcate its return result.
     */
    public static void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Prints out "Unable to load file." error message when seedu.Storage.load()
     * is unable to read text file in the file path.
     */
    public static void showLoadingError() {
        System.out.println("Unable to load file.");
    }

    /**
     * Prints out the error messages.
     *
     * @param error Error code of the error being thrown.
     */
    public static void showError(String error) {
        switch (error) {
        case "iae":
            System.out.println("     OPPS!!! Please enter a description!");
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
            break;
        default:
            break;
        }
    }
}
