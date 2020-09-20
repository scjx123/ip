package duke.task;

import duke.task.Task.commandType;
public class Event extends Task {
    public Event(String description, String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = dateTime;
        }
        this.type=commandType.E;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + "(" + dateTime + ")";
    }
}

