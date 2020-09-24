package seedu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Test Class: DukeTest")
class DukeTest {
    private static final String DateFormat = "2019-12-12@18:30";

    @Nested
    @DisplayName("Date and Year format test")
    class DateAndYear {

        //Test method
        @Test
        @Tag("dates")
        @DisplayName("😱")
        public void groupedAssertions() {
            assertAll(DateFormat,
                () -> assertEquals(DateFormat,
                            CommandParser.datetimeFormatter("eat food /by 12-12-2019 1830")),
                () -> assertEquals(DateFormat,
                            CommandParser.datetimeFormatter("eat food /by 2019-12-12 1830")));
        }
    }
}
