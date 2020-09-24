package seedu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {
    public String[] testCommands= {"done 1","done e","done 1e"};
    @Nested
    @DisplayName("when new")
    class matchCommandTest {
        StringTokenizer st = new StringTokenizer("");

        @Test
        @DisplayName("empty command ")
        void throwsInvalidCommand() {
            st=new StringTokenizer("delete 1");
            Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> CommandParser.matchCommand("delete 1", "", st));
            assertEquals("Index 0 out of bounds for length 0",exception.getMessage());
        }

//        @Test
//        @DisplayName("error input command")
//        void throwsIndexOutOfboundException(){
//            st = new StringTokenizer("done e");
//            Exception exception = assertThrows(NumberFormatException.class, () -> CommandParser.parseCommand("done e"));
//            System.out.println(exception.getMessage());
//            assertEquals("     OOPS!!! I'm sorry, but that is an invalid command :-(", exception.getMessage());
//        }

    }
}
