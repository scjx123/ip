package duke.task;

public class Event extends Task {
    public Event(String description, String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = dateTime;
        }
        this.type='E';
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + "(" + dateTime + ")";
    }
}

