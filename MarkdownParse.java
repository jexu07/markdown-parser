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
        int openBracket = 0;
        int closeBracket = 0;
        int openParen = 0;
        int closeParen = 0;

        while(currentIndex < markdown.length() && markdown.indexOf("[", currentIndex) != -1){
            int openBracketTemp = markdown.indexOf("[", currentIndex);
            if(openBracketTemp != -1){
                if(openBracketTemp != 0 && markdown.indexOf("!", openBracketTemp - 1) == openBracketTemp - 1){
                    currentIndex = openBracketTemp + 1;
                    continue;
                }
                openBracket = openBracketTemp;
            }
            else{
                break;
            }
            int closeBracketTemp = markdown.indexOf("]", openBracket);
            if(closeBracketTemp != -1){
                closeBracket = openBracketTemp;
            }
            else{
                break;
            }
            int openParenTemp = markdown.indexOf("(", closeBracket);
            if(openParenTemp != -1){
                if(openParenTemp == closeBracketTemp + 1){
                    openParen = openParenTemp;
                }
                else{
                    currentIndex = closeBracketTemp;
                    continue;
                }
            }
            else{
                break; 
            }
            int closeParenTemp = markdown.indexOf(")", openParen);
            if(closeParenTemp != -1){
                closeParen = closeParenTemp;
            }
            else{
                break;
            }
            String toAdd = markdown.substring(openParen + 1, closeParen);
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
        for(int i = 2; i < 9; i++){
            Path fileName = Path.of("test-file" + i + ".md");
            String content = Files.readString(fileName);
            ArrayList<String> links = getLinks(content);
            System.out.println(links);
        }
    
    }
    */
    
}
