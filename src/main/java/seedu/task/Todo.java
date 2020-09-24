package seedu.task;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
        this.type = CommandType.T;
    }

    @Override
    public String toString() {
        return "[" + this.type + "]" + super.toString();
    }
}
