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
    public void testParse1() throws IOException{
        List<String> expected = List.of("https://something.com", "some-thing.html");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse2() throws IOException{
        List<String> expected = List.of("https://youtube.com/watch?v=dQw4w9WgXcQ");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse3() throws IOException{
        List<String> expected = List.of("https://google.com");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse4() throws IOException{
        List<String> expected = List.of("https://youtube.com");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
}