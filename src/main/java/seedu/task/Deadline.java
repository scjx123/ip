package seedu.task;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Deadline extends Task {
    /**
     * Creates a 'Deadline' task.
     *
     * @param description Description of the task specified by user.
     * @param dateTime Date and Time of the task specified by user.
     */
    public Deadline(String description,String dateTime) {
        super(description);
        LocalDate d = LocalDate.parse(dateTime.substring(0,dateTime.indexOf("@")));
        LocalTime t = LocalTime.parse(dateTime.substring(dateTime.indexOf("@")+1));
        this.dateTime=d.format(DateTimeFormatter.ofPattern("MMM d yyyy")) +" "+ t.format(DateTimeFormatter.ofPattern("hh:mm a"));
        this.type = commandType.D;

    }

    @Override
    public String toString() {
        return "[" +this.type+ "]" + super.toString()  + dateTime  ;
    }
}