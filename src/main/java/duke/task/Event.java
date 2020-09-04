package duke.task;

public class Event extends Task {
    public Event(String description, String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = "("+ dateTime +")" ;
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + dateTime ;
    }
}

