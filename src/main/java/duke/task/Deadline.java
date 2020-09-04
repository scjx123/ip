package duke.task;

public class Deadline extends Task {

    public Deadline(String description,String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            dateTime=dateTime.replaceFirst(" ",": ");
            this.dateTime = "(" + dateTime + ")";
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + dateTime ;
    }
}