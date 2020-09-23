package duke.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    public Event(String description, String dateTime) {
        super(description);
        System.out.println(dateTime);
        LocalDate d = LocalDate.parse(dateTime.substring(0,dateTime.indexOf("@")));
        LocalTime t = LocalTime.parse(dateTime.substring(dateTime.indexOf("@")+1));
        this.dateTime=d.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +" "+ t.format(DateTimeFormatter.ofPattern("hh:mm a"));
        this.type=commandType.E;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + dateTime;
    }
}

