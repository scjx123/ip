package seedu.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Event extends Task {
    /**
     * Creates an 'Event' task.
     *
     * @param description Description of the task specified by user.
     * @param dateTime Date and Time of the task specified by user.
     */
    public Event(String description, String dateTime) {
        super(description);
        this.dateTime = dateTimeParser(dateTime);
        this.type = CommandType.E;
    }

    private String dateTimeParser(String dateTime) {
        LocalDate d = LocalDate.parse(dateTime.substring(0,dateTime.indexOf("@")));
        LocalTime t = LocalTime.parse(dateTime.substring(dateTime.indexOf("@") + 1));
        return d.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " "
                + t.format(DateTimeFormatter.ofPattern("hh:mm a"));
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString() + dateTime;
    }
}

