//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;

        while(currentIndex < markdown.length() && markdown.indexOf("[", currentIndex) != -1){
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            // Will stop the loop if no link is found
            if (openBracket == -1 || openParen == -1 || closeBracket == -1 || closeParen == -1) {
                break;
            }
            // Makes sure the close bracket and open parenthesis are next to each other
            if(openParen - 1 != closeBracket){
                currentIndex = openBracket + 1;
                continue;
            }
            // Doesn't get the link if it's an image
            if(openBracket != 0 && markdown.indexOf("!", openBracket - 1) == openBracket - 1){
                currentIndex = openBracket + 1;
                continue;
            }

            String toAdd = markdown.substring(openParen + 1, closeParen);
            int closeParenMiddle = toAdd.indexOf("(");
            while(closeParenMiddle != -1){
                closeParen = markdown.indexOf(")",closeParen + 1);
                if(closeParen == -1){
                    break;
                }                
                toAdd = markdown.substring(openParen + 1, closeParen);
                int closeParenMiddleTemp = toAdd.lastIndexOf("(");
                if(closeParenMiddle == closeParenMiddleTemp){
                    break;
                }
                closeParenMiddle = closeParenMiddleTemp;
            }

            if(toAdd.indexOf(" ") == -1){
                toReturn.add(toAdd);
            }

            currentIndex = closeParen + 1;  
        }

        return toReturn;
    }


   // original code allows you to check a file that you pass as an argument
   public static void main(String[] args) throws IOException {
        
        Path fileName = Path.of(args[0]);
        System.out.println(fileName);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.println("ha!");
    }
    
/*
    public static void main(String[] args) throws IOException {
        {    Path fileName = Path.of("test-file.md");
            String content = Files.readString(fileName);
            ArrayList<String> links = getLinks(content);
            System.out.println(links);
        }
        for(int i = 2; i < 10; i++){
            Path fileName = Path.of("test-file" + i + ".md");
            String content = Files.readString(fileName);
            ArrayList<String> links = getLinks(content);
            System.out.println(links);
        }
    
    }
    */
    
}
