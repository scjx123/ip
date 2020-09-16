package duke.task;

public class Deadline extends Task {

    public Deadline(String description,String dateTime) {
        super(description);
        if(!dateTime.isEmpty()) {
            this.dateTime=dateTime.replaceFirst(" ",": ");
        }
        this.type = 'D';
    }

    @Override
    public String toString() {
        return "[" +this.type+ "]" + super.toString() + "(" + dateTime + ")" ;
    }
}