package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class SysoutWrapperTests {

    @Test
    public void should_capture_every_line() {
        SysoutWrapper wrapper = new SysoutWrapper();
        System.setOut(wrapper);

        System.out.println("First line (0 in capture index)");
        System.out.println(new StringBuilder("Non string parameter"));
        System.out.println(34);
        System.out.println();
        System.out.println("E");

        List<String> expectedLines = new LinkedList<String>();

        expectedLines.add("First line (0 in capture index)");
        expectedLines.add("Non string parameter");
        expectedLines.add("34");
        expectedLines.add("");
        expectedLines.add("E");

        List<String> actualLines = wrapper.capturedLines;

        assertEquals("Line count", expectedLines.size(), actualLines.size());

        for (int i = 0; i < actualLines.size(); i++) {
            String actual = actualLines.get(i);
            String expected = expectedLines.get(i);

            assertEquals(String.format("Line %d", i), expected, actual);
        }
    }
}
