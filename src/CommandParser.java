import duke.DukeException.InsufficientArgumentException;
import duke.DukeException.InvalidCommandException;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;


import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CommandParser {
    static boolean exitStatus = false;

    static void parseCommand(String userCommand){
        StringTokenizer st = new StringTokenizer(userCommand);
        int dividerPosition;
        String dateTime = "";

        if (userCommand.contains("/")) {
            dividerPosition = userCommand.indexOf("/");
            dateTime = userCommand.substring(dividerPosition + 1);
            userCommand = userCommand.substring(userCommand.indexOf(' '), dividerPosition);
        }

        try {
            matchCommand(userCommand, dateTime,st);
        }catch (InsufficientArgumentException iae) {
            Ui.showError("iae");
        } catch (InvalidCommandException ie) {
            Ui.showError("ie");
        } catch (NoSuchElementException ne){
            Ui.showError("ne");
        } catch (IndexOutOfBoundsException iobe){
            Ui.showError("iobe");
        } catch (IOException e){
            Ui.showError("e");
        } catch (NumberFormatException nfe){
            Ui.showError("nfe");
        }
    }
    static void matchCommand(String userCommand,String dateTime,StringTokenizer st) throws InsufficientArgumentException, InvalidCommandException,
            NoSuchElementException, IOException, NumberFormatException {
        String tokenHolder = st.nextToken();

        switch (tokenHolder) {
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
                System.out.println("     Nice! I've marked this task as done:");
                Task.markAsDone(itemNum);
            } else {
                throw new IndexOutOfBoundsException();
            }
            break;
        case "bye":
            System.out.println("     Bye. Hope to see you again soon!");
            Storage.writeFile(Task.getList());
            exitStatus=true;
            break;
        case "todo":
            if (!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            }
            new Todo(userCommand);
            Task.printTask();
            break;
        case "deadline":
            if (!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            }
            new Deadline(userCommand, dateTime);
            Task.printTask();
            break;
        case "event":
            if (!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            }
            new Event(userCommand, dateTime);
            Task.printTask();
            break;
        default:
            throw new InvalidCommandException();
        }
    }

    public static boolean isExit(){
        return exitStatus;
    }
}



