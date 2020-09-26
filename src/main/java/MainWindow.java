import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import seedu.Duke;
import seedu.Ui;


/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;


    private seedu.Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image nickImage = new Image(this.getClass().getResourceAsStream("/images/nickfury.jpg"));
    private Image steveImage = new Image(this.getClass().getResourceAsStream("/images/steve.jpg"));
    private Image tonyImage = new Image(this.getClass().getResourceAsStream("/images/stark.jpg"));
    private Image romanoffImage = new Image(this.getClass().getResourceAsStream("/images/romanoff.jpg"));

    public enum CharacterChoice {
        STEVE,STARK,ROMANOFF,NULL
    }

    public CharacterChoice choice = CharacterChoice.NULL;

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    public void setDuke(Duke d) {
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(Ui.guiWelcome(), nickImage));
        duke = d;
    }

    public MainWindow(){
    }

    public static boolean isExit = false;

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        setChoice(input);
        String response = duke.getResponse(input);

        if (choice == CharacterChoice.STEVE) {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getDukeDialog(response, steveImage)
            );
        } else if (choice == CharacterChoice.STARK) {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getDukeDialog(response, tonyImage)
            );
        } else if (choice == CharacterChoice.ROMANOFF) {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getDukeDialog(response, romanoffImage)
            );
        } else if (choice == CharacterChoice.NULL) {
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage),
                    DialogBox.getDukeDialog(response, nickImage)
            );
        }
        if (input.equals("bye")) {
            isExit = true;
        } else {
            userInput.clear();
        }

    }

    private void setChoice(String input) {
        switch (input.toLowerCase()) {
        case "steve":
            choice = CharacterChoice.STEVE;
            break;
        case "tony":
            choice = CharacterChoice.STARK;
            break;
        case "romanoff":
            choice = CharacterChoice.ROMANOFF;
            break;
        default:
            break;
        }

    }
}