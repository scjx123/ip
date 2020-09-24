package seedu;

import java.util.List;


public class TaskList {

    public TaskList(List<String> loadedList){
        CommandParser c = new CommandParser();
        c.loadData(loadedList);
    }
    public TaskList(){
    }
}
