package duke.task;
import duke.task.Task.commandType;

public class Deadline extends Task {

    public Deadline(String description,String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            this.dateTime=dateTime.replaceFirst(" ",": ");
        }
        this.type = commandType.D;
    }

    @Override
    public String toString() {
        return "[" +this.type+ "]" + super.toString() + "(" + dateTime + ")" ;
    }
}