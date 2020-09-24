package seedu;

import javafx.application.Application;
import seedu.Duke;

/**
 * A launcher class to workaround classpath issues.
 */
public class Launcher {

    public static void main(String[] args) {
        Application.launch(Duke.class, args);
    }
}