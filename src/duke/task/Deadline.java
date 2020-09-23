package duke.task;

public class Deadline extends Task {

    /**
     * Creates a 'Deadline' task.
     *
     * @param description Description of the task specified by user.
     * @param dateTime Date and Time of the task specified by user.
     */
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