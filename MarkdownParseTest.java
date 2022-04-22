import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testParse() throws IOException{
        List<String> expected = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
}