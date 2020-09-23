package duke.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import duke.task.Task.commandType;

public class Event extends Task {
    public Event(String description, String dateTime) {
        super(description);
        LocalDate d = LocalDate.parse(dateTime.substring(0,dateTime.indexOf("@")));
        LocalTime t = LocalTime.parse(dateTime.substring(dateTime.indexOf("@")+1));
        this.dateTime=d.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +" "+ t.format(DateTimeFormatter.ofPattern("hh:mm a"));
        /*if(!dateTime.isEmpty()) {
            this.dateTime=dateTime.replaceFirst(" ",": ");
        }*/
        this.type=commandType.E;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + dateTime;
    }
}

