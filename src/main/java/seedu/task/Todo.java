package seedu.task;

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
