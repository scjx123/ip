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
        String[] tempDateTime = new String[3];
        String year, month, day,time;

        if (userCommand.contains("/")) {
            //Divide between Task description and Task date
            dividerPosition = userCommand.indexOf("/") + 3;
            dateTime = userCommand.substring(dividerPosition + 1);

            time = dateTime.substring(dateTime.indexOf(" "));
            time = time.substring(1,3)+":"+time.substring(3);
            dateTime = dateTime.substring(0,dateTime.indexOf(" "));

            //Re-format the date given by the user
            if (dateTime.contains("/")) {
                tempDateTime = dateTime.split("/", 3);
            } else {
                tempDateTime = dateTime.split("-", 3);
            }
            //figure out user entered year first or day first .
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
                dateTime = year + "-" + month + "-0" + day+"@"+time;
            } else {
                dateTime = year + "-" + month + "-" + day+"@"+time;
            }


            //System.out.println(dateTime);
            userCommand = userCommand.substring(userCommand.indexOf(' '), dividerPosition - 3) + "by: ";
        } else {
            if (st.hasMoreTokens()) {
                userCommand = userCommand.substring(userCommand.indexOf(' '));
              //  userCommand = userCommand.substring(userCommand.indexOf(' '), dividerPosition);
            }

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
            exitStatus = true;
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

    public static boolean isExit() {
        return exitStatus;
    }
}



