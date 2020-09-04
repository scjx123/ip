package duke.command;

import duke.InsufficientArgumentException;
import duke.InvalidCommandException;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;
import java.util.Scanner;
import java.util.StringTokenizer;

public interface Command {
    public static String getCommand() {
        String userCommand;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();
        return userCommand;
    }

    public static void matchCommand(String userCommand) throws InsufficientArgumentException, InvalidCommandException {
        StringTokenizer st = new StringTokenizer(userCommand);
        String tokenHolder = st.nextToken();

        int dividerPosition = 0;
        String dateTime = "";

        if(userCommand.contains("/")) {
            dividerPosition = userCommand.indexOf('/');
            dateTime=userCommand.substring(dividerPosition+1);
            userCommand=userCommand.substring(userCommand.indexOf(' '),dividerPosition);
        } else {
            if(st.hasMoreTokens()) {
                userCommand = userCommand.substring(userCommand.indexOf(' '));
            }
        }

        switch (tokenHolder) {
        case "list":
            Task.printList();
            break;
        case "done":
            System.out.println("     Nice! I've marked this task as done:");
            int itemNum = Integer.parseInt(st.nextToken())-1;
            if(Task.itemExist(itemNum)) {
                Task.markAsDone(itemNum);
            }
            break;
        case "bye":
            System.out.println("     Bye. Hope to see you again soon!");
            break;
        case "todo":
            if(!st.hasMoreTokens()){
                throw new InsufficientArgumentException();
            }
            new Todo(userCommand);
            Task.printTask();
            break;
        case "deadline":
            if(!st.hasMoreTokens()){
                throw new InsufficientArgumentException();
            }
            new Deadline(userCommand,dateTime);
            Task.printTask();
            break;
        case "event":
            if(!st.hasMoreTokens()){
                throw new InsufficientArgumentException();
            }
            new Event(userCommand,dateTime);
            Task.printTask();
            break;
        default:
            throw new InvalidCommandException();
//            break;
        }
    }
}



