import duke.DukeException.InsufficientArgumentException;
import duke.DukeException.InvalidCommandException;
import duke.task.TaskList;

import java.io.IOException;
import java.util.NoSuchElementException;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch ( IOException io) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                CommandParser c= new CommandParser();
                CommandParser.matchCommand(fullCommand);
                isExit = c.isExit();
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
            } finally {
                ui.showLine();
            }
        }
    }
    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
//    public static void main(String[] args) {
//
//        String userCommand;
//        try{
//            Command.load();
//        }catch (IOException e){
//            System.out.println("    Unable to read.");
//        }
//
//        while (true) {
//            userCommand = Command.getCommand();
//            System.out.println("    ____________________________________________________________");
//            try {
//                Command.matchCommand(userCommand);
//            } catch (InsufficientArgumentException iae) {
//                System.out.println("     OPPS!!! The description of a todo cannot be empty.");
//            } catch (InvalidCommandException ie) {
//                System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
//            } catch (NoSuchElementException ne){
//                System.out.println("     OOPS!!! I'm sorry, please specify which item done/to be deleted :-(");
//            } catch (IndexOutOfBoundsException iobe){
//                System.out.println("     OOPS!!! I'm sorry, task does not exist in the list :-(");
//            } catch (IOException e){
//                System.out.println("     Unable to write.");
//            }
//            System.out.println("    ____________________________________________________________");
//            if (userCommand.equals("bye")) {
//                System.exit(1);
//            }
//        }
//    }
}


