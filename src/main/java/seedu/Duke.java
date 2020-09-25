package seedu;

import seedu.dukeexception.InvalidCommandException;
import java.io.IOException;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Empty constructor to bypass classpath issue for JavaFx.
     */
    public Duke(){

    }

    /**
     * Passes the filePath variable to storage class to further read/load in existing data
     * The same path is also used for writing. This constructor catches error thrown from
     * storage.load() method as well.
     *
     * @param filePath an absolute path of the text file that stores user data.
     */

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException io) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    /**
     * Shows the main workflow when the app is running. isExit will be true once the
     * user types in 'bye' command.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                CommandParser c = new CommandParser();
                CommandParser.parseCommand(fullCommand);
                ui.showLine();
                isExit = c.isExit();
            } catch (InvalidCommandException ie) {
                ui.showError("ie");
            }

        }
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }


    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        ui.showWelcome();
        String fullCommand = input;
        CommandParser c = new CommandParser();
        c.parseCommand(fullCommand);

        return Ui.concat;
    }
}


