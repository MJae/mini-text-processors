/*
 * Write a program that reads one line of input text and breaks it up into
 * words. The (solution) words should be output one per line. A word is defined
 * to be a sequence of letters. Any characters in the input that are not
 * letters should be discarded. For example, if the user inputs the line 
 *
 *   He said, "That’s not a good idea."
 *
 * then the output of the program should be
 * 
 *   He
 *   said
 *   that
 *   s
 *   not
 *   a
 *   good
 *   idea
 * 
 * An improved version of the program would list “that’s” as a single word. An
 * apostrophe can be considered to be part of a word if there is a letter on
 * each side of the apostrophe.
 *
 * To test whether a character is a letter, you might use
 * (ch >= ’a’ && ch <=’z’) || (ch >= ’A’ && ch <= ’Z’).
 * However, this only works in English and similar languages. A better choice
 * is to call the standard function Character.isLetter(ch), which returns a
 * boolean value of true if ch is a letter and false if it is not. This works
 * for any Unicode character.
 */
 
public class LinesToWords {

    public static void main(String[] args) {
    
        System.out.println("\nThis program asks the user for a line of text " +
            "then displays the text as separate word in different lines.");
    
        // Allow multiple operations
        while (true){
            
            System.out.print("\nGive me a line: ");
            String usrStr;
            usrStr = TextIO.getln();
            
            String word = " ";
            int i;
            int max = usrStr.length();
            for (i = 0; i < max; i++){
                char c = usrStr.charAt(i);
                if (Character.isLetter(c) || c == '\''){
                    word += c;
                }
                else {
                    if (!word.equals(" ")) {
                        System.out.println(word);
                        word = " ";
                    }
                }
            }
        
            // Ask user if he/she wants to try again
            char choice;
            System.out.print("\nDo you want to try again?" +
                "\n (Enter \'y\' or \'Y\' to try again) " );
            choice = TextIO.getlnChar();
            if (choice == 'y' || choice == 'Y')
                continue;
            else
                break;
        } // end execution
        
    } // end main ()
    
} // end class DicePair


