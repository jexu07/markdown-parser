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
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse2() throws IOException{
        List<String> expected = List.of("https://something.com", "some-page.html");
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse3() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse4() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse5() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse6() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file6.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParse7() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file7.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    
    @Test
    public void testParse8() throws IOException{
        List<String> expected = List.of();
        Path fileName = Path.of("test-file8.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt1() throws IOException{
        List<String> expected = List.of("https://youtube.com/watch?v=dQw4w9WgXcQ");
        Path fileName = Path.of("testing.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt2() throws IOException{
        List<String> expected = List.of("https://google.com");
        Path fileName = Path.of("testing2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseAlt3() throws IOException{
        List<String> expected = List.of("https://youtube.com");
        Path fileName = Path.of("testing3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testParseLabTest1() throws IOException{
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        Path fileName = Path.of("lab-test1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
   
    @Test
    public void testParseLabTest2() throws IOException{
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        Path fileName = Path.of("lab-test2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }
    
    @Test
    public void testParseLabTest3() throws IOException{
        List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        Path fileName = Path.of("lab-test3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void TestParseBreak1() throws IOException{
        List<String> expected = List.of("https://en.wikipedia.org/wiki/Diego_(tortoise)");
        Path fileName = Path.of("break-test.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(expected, links);
    }

    @Test
    public void testFileExistence() throws IOException{
        Path fileName = Path.of("testing.md");
        String content = Files.readString(fileName);
    }
    /*
    @Test
    public void testFileExistence2() throws IOException{
        Path fileName = Path.of("github.com/jexu07/markdown-parser/blob/main/test-file6.md");
        String content = Files.readString(fileName);
    }
    */
}