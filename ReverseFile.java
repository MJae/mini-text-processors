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
 * usage: java ReverseFile [input file name]
 */
public class ReverseFile {
    
    public static void main(String[] args) {
        
        // Check to make sure that a file was entered as argument.
        if (args.length != 1) {
            System.err.println("Usage: java ReverseFile <filename>");
            System.exit(0);
        }
        
        // Get the contents of the file.
        Scanner originalFile;
        ArrayList<String> contents = new ArrayList<String>();
        
        try {
            originalFile = new Scanner(new File(args[0]));
            while (originalFile.hasNext()){
                String words = originalFile.nextLine();
                
                // Markers for whitespaces.
                int a = 0, b;
                int l = words.length() - 1;
                String word;
                for (int i = 0; i < words.length(); i++) {
                    if (words.charAt(i) == ' ' || i == l) {
                        if (i != l)
                            b = i;
                        else
                            b = words.length();
                        word = words.substring(a, b);
                        contents.add(word);
                        if (i != l) {
                            contents.add(" ");
                            a = b + 1;
                        }
                    }
                }
                if (originalFile.hasNext())
                    contents.add("\n");
                
            }
            originalFile.close();
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        
        // Write them back into the file but in reverse.
        PrintWriter reversedFile;
        try {
            reversedFile = new PrintWriter(new FileWriter(args[0]));
            for (int i = contents.size() - 1; i >= 0; i--) {
                String content = contents.get(i);
                reversedFile.print(content);
            }
            reversedFile.close();
            
            System.out.println("Done.");
        }
        catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

    } // end main()
    
} // end class ReverseFile

