package duke.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


import duke.task.Task.commandType;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
        this.type=commandType.T;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString();
    }
}
