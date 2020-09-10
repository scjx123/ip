import duke.command.Command;
import duke.InsufficientArgumentException;
import duke.InvalidCommandException;
import java.io.IOException;
import java.util.NoSuchElementException;

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

        String userCommand;
        try{
            Command.load();
        }catch (IOException e){
            System.out.println("    Unable to read.");
        }

        while (true) {
            userCommand = Command.getCommand();
            System.out.println("    ____________________________________________________________");
            try {
                Command.matchCommand(userCommand);
            } catch (InsufficientArgumentException iae) {
                System.out.println("     OPPS!!! The description of a todo cannot be empty.");
            } catch (InvalidCommandException ie) {
                System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
            } catch (NoSuchElementException ne){
                System.out.println("     OOPS!!! I'm sorry, please specify which item done/to be deleted :-(");
            } catch (IndexOutOfBoundsException iobe){
                System.out.println("     OOPS!!! I'm sorry, task does not exist in the list :-(");
            } catch (IOException e){
                System.out.println("     Unable to write.");
            }
            System.out.println("    ____________________________________________________________");
            if (userCommand.equals("bye")) {
                System.exit(1);
            }
        }
    }
}


