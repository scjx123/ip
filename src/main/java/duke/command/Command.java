package duke.command;

import duke.InsufficientArgumentException;
import duke.InvalidCommandException;
import duke.task.Event;
import duke.task.Task;
import duke.task.Todo;
import duke.task.Deadline;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.io.File;



public interface Command {
    String filePath = "line.txt";
    File f = new File(filePath);

    /**
     *  loadedTask[0] indicates the type of task.
     *  loadedTask[1] indicates done or not done.
     *  loadedTask[2] indicates the task description.
     */
    static void load() throws IOException {
        Scanner s = new Scanner(f);
        while(s.hasNext()){
            String[] loadedTask= s.nextLine().split(" ",3);
            String loadedCommand;
            int index = loadedTask[2].indexOf("/");
            loadedCommand = loadedTask[2].substring(0,index);
            String loadedDateTime = loadedTask[2].substring(index+1);
            switch(loadedTask[0]){
            case "T":
                Todo object_T = new Todo(loadedCommand);
                Task.markAsDone(object_T,loadedTask[1].equals("true"));
                break;
            case "D":
                Event object_D = new Event(loadedCommand,loadedDateTime);
                Task.markAsDone(object_D,loadedTask[1].equals("true"));
                break;
            case "E":
                Deadline object_E = new Deadline(loadedCommand,loadedDateTime);
                Task.markAsDone(object_E,loadedTask[1].equals("true"));
                break;
            default:
                break;
            }
        }
    }

    static String getCommand() {
        String userCommand;
        Scanner userInput = new Scanner(System.in);
        userCommand = userInput.nextLine();
        return userCommand;
    }


    static void matchCommand(String userCommand) throws InsufficientArgumentException, InvalidCommandException,
            NoSuchElementException, IOException{

        StringTokenizer st = new StringTokenizer(userCommand);
        String tokenHolder = st.nextToken();
        int dividerPosition;
        String dateTime = "";

        if(userCommand.contains("/")) {
            dividerPosition = userCommand.indexOf("/");
            dateTime=userCommand.substring(dividerPosition+1);
            userCommand=userCommand.substring(userCommand.indexOf(' '),dividerPosition);
        } else {
            if(st.hasMoreTokens()) {
                userCommand = userCommand.substring(userCommand.indexOf(' '));
            }
        }

        switch (tokenHolder) {
        case "delete":
            int itemNum = Integer.parseInt(st.nextToken()) - 1;
            if (Task.itemExist(itemNum)){
                Task.removeItem(itemNum);
            }else{
                throw new IndexOutOfBoundsException();
            }
            break;
        case "list":
            Task.printList();
            break;
        case "done":
            itemNum = Integer.parseInt(st.nextToken()) - 1;
            if(Task.itemExist(itemNum)){
                    System.out.println("     Nice! I've marked this task as done:");
                    Task.markAsDone(itemNum);
            }else{
                    throw new IndexOutOfBoundsException();
            }
            Task.writeFile(filePath);
            break;
        case "bye":
            System.out.println("     Bye. Hope to see you again soon!");
            break;
        case "todo":
            if(!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            }
            new Todo(userCommand);
            Task.printTask();
            Task.writeFile(filePath);
            break;
        case "deadline":
            if(!st.hasMoreTokens()) {
                throw new InsufficientArgumentException();
            }
            new Deadline(userCommand,dateTime);
            Task.printTask();
            Task.writeFile(filePath);
            break;
        case "event":
            if(!st.hasMoreTokens()){
                throw new InsufficientArgumentException();
            }
            new Event(userCommand,dateTime);
            Task.printTask();
            Task.writeFile(filePath);
            break;
        default:
            throw new InvalidCommandException();
//            break;
        }
    }
}



