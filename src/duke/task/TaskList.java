package duke.task;

import java.util.List;

public class TaskList {

    public TaskList(List<String> loadedList){
        Task.loadData(loadedList);
    }
    public TaskList(){
    }
}
