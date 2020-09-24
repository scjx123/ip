package seedu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Test Class: DukeTest")
class DukeTest {

    private static final String DateFormat = "2019-12-12@18:30";
    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class True_and_False_test{
        //Test method
        @Test
        @Tag("dates")
        @DisplayName("😱")
        public void groupedAssertions() {
            assertAll(DateFormat,
                    () -> assertEquals(DateFormat,CommandParser.datetimeFormatter("eat food /by 12-12-2019 1830")),
                    () -> assertEquals(DateFormat,CommandParser.datetimeFormatter("eat food /by 2019-12-12 1830"))
            );
        }


//        @Test
//        @EnabledOnOs(OS.MAC)
//        void exceptionTesting() {
//            Exception exception = assertThrows(Exception.class, () ->
//                    calculator.divide(1, 0));
//            assertEquals("/ by zero", exception.getMessage());
//        }


    }

}
