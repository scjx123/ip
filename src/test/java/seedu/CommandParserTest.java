package seedu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandParserTest {
    public String[] testCommands = {"done 1","done e","done 1e"};

    @Nested
    @DisplayName("when new")
    class MatchCommandTest {
        StringTokenizer st = new StringTokenizer("");

        @Test
        @DisplayName("empty command ")
        void throwsInvalidCommand() {
            st = new StringTokenizer("delete 1");
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                    CommandParser.matchCommand("delete 1", "", st));
            assertEquals("Index 0 out of bounds for length 0",exception.getMessage());
        }
    }
}
