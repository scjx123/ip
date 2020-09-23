import duke.DukeException.InsufficientArgumentException;
import duke.DukeException.InvalidCommandException;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CommandParser {
    static boolean exitStatus = false;

    static String loadedCommand;
    static String loadedDateTime;
    static String formattedUserCommand;
    static String formattedDateTime;
    static String originalDateTime="";
    static int dividerPosition;
    static String dateTime = "";
    static String[] tempDateTime;
    static String year, month, day,time;

    static void readCommand(List<String> lineArray){
        for(String str : lineArray ) {
            if (str != null) {
                String[] loadedTask = str.split(" ", 3);
                System.out.println(loadedTask[0]);
                System.out.println(loadedTask[1]);
                System.out.println(loadedTask[2]);

                if(loadedTask[2].contains("by: ")){
                    loadedTask[2]=loadedTask[2].replace("by: ","/by");
                    loadedCommand=userCommandFormatter(loadedTask[2],true);
                    loadedDateTime=datetimeFormatter(loadedTask[2]);
                }else {
                    loadedCommand=loadedTask[2];
                }

                switch (str.charAt(0)) {
                case 'T':
                    Todo object_T = new Todo(loadedCommand);
                    Task.markAsDone(object_T, loadedTask[1].equals("true"));
                    break;
                case 'E':
                    Event object_D = new Event(loadedCommand, loadedDateTime);
                    Task.markAsDone(object_D, loadedTask[1].equals("true"));
                    break;
                case 'D':
                    Deadline object_E = new Deadline(loadedCommand, loadedDateTime);
                    Task.markAsDone(object_E, loadedTask[1].equals("true"));
                    break;
                default:
                    break;
                }
            }
        }
    }
    static String userCommandFormatter(String userCommand,boolean containsSlash){
        if(containsSlash) {
            dividerPosition = userCommand.indexOf("/") + 3;
            formattedUserCommand = userCommand.substring(userCommand.indexOf(' '), dividerPosition - 3) + "by: ";
        }else {
            formattedUserCommand = userCommand.substring(userCommand.indexOf(' ')+1);
        }
        return formattedUserCommand;
    }
    static String datetimeFormatter(String userCommand){
        //Divide between Task description and Task date
        dividerPosition=userCommand.indexOf("/")+3;
        formattedDateTime = userCommand.substring(dividerPosition + 1);
        originalDateTime=formattedDateTime;
        time = formattedDateTime.substring(formattedDateTime.indexOf(" "));
        time = time.substring(1,3)+":"+time.substring(3);
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
            formattedDateTime = year + "-" + month + "-0" + day+"@"+time;
        } else {
            formattedDateTime = year + "-" + month + "-" + day+"@"+time;
        }
        return formattedDateTime;
    }
    static void parseCommand(String userCommand){
        StringTokenizer st = new StringTokenizer(userCommand);

        if (userCommand.contains("/")) {
            dateTime=datetimeFormatter(userCommand);
            userCommand = userCommandFormatter(userCommand,true);
        } else {
            userCommand = userCommandFormatter(userCommand,false);
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
        case "find":
            Task.find(st.nextToken());
            break;
        default:
            throw new InvalidCommandException();
        }
    }

    public static boolean isExit() {
        return exitStatus;
    }

}



