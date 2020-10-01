package seedu;

import seedu.dukeexception.InsufficientArgumentException;
import seedu.dukeexception.InvalidCommandException;
import seedu.task.Event;
import seedu.task.Task;
import seedu.task.Todo;
import seedu.task.Deadline;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CommandParser {
    public static boolean exitStatus = false;
    static final int NOTUSED = -1;
    static String loadedCommand;
    static String loadedDateTime;
    public static String formattedUserCommand;
    public static String formattedDateTime;
    public static String originalDateTime = "";
    private static int dividerPosition;
    protected static String dateTime = null;
    private static String[] tempDateTime;
    private static String year;
    private static String month;
    private static String day;
    private static String time;

    /**
     * Create object based on commands that were loaded from text file.
     *
     * @param lineArray Contains lines of data that were previously entered by user
     */
    static void loadData(List<String> lineArray) {
        for (String str : lineArray) {
            if (str != null) {
                String[] loadedTask = str.split(" ", 3);

                if (loadedTask[2].contains("by: ")) {
                    loadedTask[2] = loadedTask[2].replace("by: ","/by");
                    loadedCommand = userCommandFormatter(loadedTask[2],true);
                    loadedDateTime = datetimeFormatter(loadedTask[2]);
                } else {
                    loadedCommand = loadedTask[2];
                }

                switch (str.charAt(0)) {
                case 'T':
                    Todo objectTask = new Todo(loadedCommand);
                    Task.markAsDone(objectTask, loadedTask[1].equals("true"));
                    break;
                case 'E':
                    Event objectDeadline = new Event(loadedCommand, loadedDateTime);
                    Task.markAsDone(objectDeadline, loadedTask[1].equals("true"));
                    break;
                case 'D':
                    Deadline objectEvent = new Deadline(loadedCommand, loadedDateTime);
                    Task.markAsDone(objectEvent, loadedTask[1].equals("true"));
                    break;
                default:
                    break;
                }
            }
        }
    }

    /**
     * Formats the userCommand to sieve out the task description.
     * It also replaces '/by' with 'by:' for printing purposes in later on.
     *
     * @param userCommand The unformatted string entered by user.
     * @param containsSlash True if userCommand contains slash, false otherwise.
     * @return Returns the formatted userCommand with only its description.
     */
    static String userCommandFormatter(String userCommand,boolean containsSlash) {
        if (containsSlash) {
            dividerPosition = userCommand.indexOf("/") + 3;
            formattedUserCommand = userCommand.substring(userCommand.indexOf(' '), dividerPosition - 3) + "by: ";
        } else {
            formattedUserCommand = userCommand.substring(userCommand.indexOf(' ') + 1);
        }
        return formattedUserCommand;
    }

    /**
     * Formats the userCommand to sieve out the task date and time.
     * If the date was 12/09/2019 it will be changed to 12-09-2019.
     * It also detects whether the user entered 2019/12/1 or 1/12/2019.
     *
     * @param userCommand The unformatted string entered by user.
     * @return Returns the formatted userCommand with only its date and time information.
     */
    static String datetimeFormatter(String userCommand) throws NumberFormatException {
        //Divide between Task description and Task date
        dividerPosition = userCommand.indexOf("/") + 3;
        formattedDateTime = userCommand.substring(dividerPosition + 1);
        originalDateTime = formattedDateTime;
        time = formattedDateTime.substring(formattedDateTime.indexOf(" "));
        time = time.substring(1,3) + ":" + time.substring(3);
        formattedDateTime = formattedDateTime.substring(0,formattedDateTime.indexOf(" "));

        //Re-format the date given by the user
        if (formattedDateTime.contains("/")) {
            tempDateTime = formattedDateTime.split("/", 3);
        } else {
            tempDateTime = formattedDateTime.split("-", 3);
        }

        //Figure out whether user entered year first or day first .
        if (tempDateTime[0].length() > tempDateTime[2].length()) {
            year = tempDateTime[0];
            day = tempDateTime[2];
        } else {
            year = tempDateTime[2];
            day = tempDateTime[0];
        }
        month = tempDateTime[1];

        //String building
        if (Integer.parseInt(day) < 10 && !day.contains("0")) {
            formattedDateTime = year + "-" + month + "-0" + day + "@" + time;
        } else {
            formattedDateTime = year + "-" + month + "-" + day + "@" + time;
        }
        return formattedDateTime;
    }

    /**
     * Controls the flow of how a new userCommand is processed.
     * It also catches error that is thrown by the matchCommand method.
     *
     * @param userCommand The unformatted string entered by user.
     */
    static void parseCommand(String userCommand) {
        StringTokenizer st = new StringTokenizer(userCommand);

        try {
            if (userCommand.contains("/")) {
                dateTime = datetimeFormatter(userCommand);
                userCommand = userCommandFormatter(userCommand,true);
            } else {
                userCommand = userCommandFormatter(userCommand,false);
            }
            matchCommand(userCommand, dateTime,st);
            dateTime = null;
        } catch (InsufficientArgumentException iae) {
            Ui.showError("iae");
        } catch (InvalidCommandException ie) {
            Ui.showError("ie");
        } catch (NoSuchElementException ne) {
            Ui.showError("ne");
        } catch (IndexOutOfBoundsException iobe) {
            Ui.showError("iobe");
        } catch (IOException e) {
            Ui.showError("e");
        } catch (NumberFormatException nfe) {
            Ui.showError("nfe");
        }
    }

    /**
     * Matches the given command with the possible task object and subsequently, take necessary action that
     * relates to the command itself.
     * Relevant errors are being thrown here as well. Read below for Error information.
     *
     * @param userCommand The unformatted string entered by user.
     * @param dateTime The formatted date and time information keyed in by user.
     * @param st A StringTokenizer that holds the original userCommand information.
     * @throws InsufficientArgumentException Thrown when user provides insufficient argument after a valid first word.
     * @throws InvalidCommandException Thrown when user pressed 'enter' without keying anything or it does not make
     *                                 the word entered is not recognized by switch statement.
     * @throws NoSuchElementException Thrown when non existing element if expected.
     * @throws IOException Thrown by writeFile() in the "bye" case of switch statement.
     * @throws NumberFormatException Thrown when user keys in illegal number format following a valid first word.
     */
    static void matchCommand(String userCommand,String dateTime,StringTokenizer st)
            throws InsufficientArgumentException, InvalidCommandException,
            NoSuchElementException, IOException, NumberFormatException {

        /** TokenHolder holds the first word of the userCommand, which enables the use of Switch statement */
        String tokenHolder = st.nextToken();

        switch (tokenHolder.toLowerCase().trim()) {
        case "hi":
            Ui.taskIO("hi",null,NOTUSED);
            break;
        case "delete":
            int itemNum = Integer.parseInt(st.nextToken()) - 1;
            if (Task.itemExist(itemNum)) {
                Task.removeItem(itemNum);
            } else {
                throw new IndexOutOfBoundsException();
            }
            break;
        case "list":
            Task.printList();
            break;
        case "done":
            itemNum = Integer.parseInt(st.nextToken()) - 1;
            if (Task.itemExist(itemNum)) {
                Task.markAsDone(itemNum);
            } else {
                throw new IndexOutOfBoundsException();
            }
            break;
        case "bye":
            Ui.taskIO("bye",null,NOTUSED);
            Storage.writeFile(Task.getList());
            exitStatus = true;
            break;
        case "todo":
            if (!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            } else {
                new Todo(" " + userCommand);
                Task.printTask();
            }
            break;
        case "deadline":
            if (!st.hasMoreTokens() || dateTime == null) {
                throw new InsufficientArgumentException();
            } else {
                new Deadline(userCommand, dateTime);
                Task.printTask();
            }
            break;
        case "event":
            if (!st.hasMoreTokens() || dateTime == null) {
                throw new InsufficientArgumentException();
            } else {
                new Event(userCommand, dateTime);
                Task.printTask();
            }
            break;
        case "find":
            Task.find(st.nextToken());
            break;
        case "tony":
            Ui.agentMessage("tony");
            break;
        case "romanoff":
            Ui.agentMessage("romanoff");
            break;
        case "steve":
            Ui.agentMessage("steve");
            break;
        default:
            Ui.agentMessage("nick");
            throw new InvalidCommandException();
        }
    }

    /**
     * Returns the status of exitStatus.
     *
     * @return Returns exitStatus.
     */
    public static boolean isExit() {
        return exitStatus;
    }
}



