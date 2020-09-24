package seedu;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import seedu.dukeexception.InvalidCommandException;

import java.io.IOException;

public class Duke extends Application {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    @Override
    public void start(Stage stage) {
        Label helloWorld = new Label("Hello World!"); // Creating a new Label control
        Scene scene = new Scene(helloWorld); // Setting the scene to be our Label

        stage.setScene(scene); // Setting the stage to show our screen
        stage.show(); // Render the stage.
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
}


