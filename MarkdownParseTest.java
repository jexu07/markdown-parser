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
        List<String> expected = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse3() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse4() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse5() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse6() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse7() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    
    @Test
    public void testParse8() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt1() throws IOException{
        List<String> expected = List.of("https://youtube.com/watch?v=dQw4w9WgXcQ");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt2() throws IOException{
        List<String> expected = List.of("https://google.com");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt3() throws IOException{
        List<String> expected = List.of("https://youtube.com");
        Path fileName = Path.of("C:/Users/jerry/Documents/GitHub/markdown-parser/testing3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }


    @Test
    public void testFileExistence() throws IOException{
        Path fileName = Path.of("testing.md");
        String content = Files.readString(fileName);
    }
}