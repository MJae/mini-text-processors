import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class reverses the letters/words/numbers of an input file, so that the
 * last letter/word/number becomes the first and the first letter/word/number
 * is now last.
 *
 * Any kind of data may be used in the file.
 *
 * usage: java Reverse [input file name]
 */
public class Reverse {
    
    public static void main(String[] args) {
        
        // Check to make sure that a file was entered as argument.
        if (args.length != 1) {
            System.err.println("Usage: java Reverse <filename>");
            System.exit(0);
        }
        
        // Process the file.
        Scanner originalFile;
        ArrayList<String> contents = new ArrayList<String>();
        
        try {
            originalFile = new Scanner(new File(args[0]));
            while (originalFile.hasNext()){
                String word = originalFile.next();
                contents.add(word);
            }
            
            for (int i = contents.size() - 1; i >= 0; i--) {
                String content = contents.get(i);
                /*
                if (content.length() > 1) 
                    reverseCharacters(content);
                else
                */
                System.out.print(content);
                System.out.print(" ");
            }
            System.out.println();
            
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
                
    }
    
    /*
    public static void reverseCharacters(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
        }
    }
    */

}

