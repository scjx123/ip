

import java.util.List;


public class TaskList {

    public TaskList(List<String> loadedList){
        CommandParser c = new CommandParser();
        c.readCommand(loadedList);
    }
    public TaskList(){
    }
}
