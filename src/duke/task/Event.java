package duke.task;

public class Event extends Task {
    /**
     * Creates an 'Event' task.
     *
     * @param description Description of the task specified by user.
     * @param dateTime Date and Time of the task specified by user.
     */
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

