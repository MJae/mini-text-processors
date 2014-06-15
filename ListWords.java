/*
 * Write a program that will read a text file selected by the user, and will
 * make an alphabetical list of all the different words in that file. All words
 * should be converted to lower case, and duplicates should be eliminated from
 * the list. The list should be written to an output file selected by the user.
 */
 
import java.util.ArrayList;

/**
 * This class reads a text file selected by the user, makes an alphabetical
 * list of all the words in the file, and write the list to an output file
 * selected by the user.
 */
public class ListWords {

    /**
     * Read the next word from TextIO, if there is one. First, skip past
     * any non-letters in the input. If an end-of-file is encountered before
     * a word is found, return null. Otherwise, read and return the word.
     * A word is defined as a sequence of letters. Also, a word can include
     * an apostrophe if the apostrophe is surrounded by letters on each side.
     * @return the next word from TextIO, or null if an end-of-file is
     * encountered
     */
    private static String readNextWord() {
    
        char ch = TextIO.peek();  // Look at next character in input.
        while (ch != TextIO.EOF && ! Character.isLetter(ch)) {
            TextIO.getAnyChar();  // Read the character.
            ch = TextIO.peek();  // Look at the next character.
        }
        
        if (ch == TextIO.EOF) // Encountered end-of-file
            return null;
    
        // At this point, we know the next character is a letter,
        // so read a word.
        String word = ""; // This will be the word that is read.
        while (true) {
        
            word += TextIO.getAnyChar();  // Append the letter onto word.
            ch = TextIO.peek(); // Look at next character.
            if ( ch == '\'' ) {
            
                // The next character is an apostrophe. Read it, and
                // if the following character is a letter, add both the
                // apostrophe and the letter onto the word and continue
                // reading the word. If the character after the apostrophe
                // is not a letter, the word is done, so break out of the loop.
                
                TextIO.getAnyChar();  // Read the apostrophe.
                ch = TextIO.peek();  // Look at char that follows apostrophe.
                if (Character.isLetter(ch)) {
                    word += "\'" + TextIO.getAnyChar();
                    ch = TextIO.peek();  // Look at next char.
                }
                else
                    break;
                    
            } // end if
            
            if ( ! Character.isLetter(ch) ) {
                // If the next character is not a letter, the word is
                // finished, so break out of the loop.
                break;  
            }
            // If we haven’t broken out of the loop, next char is a letter.
                    
        } // end while
        
        return word;  // Return the word that has been read.
    
    } // end readNextWord()
    
    /**
     * Arrange the words in a list of words in alphabetical order. First,
     * change all the letters in the words into lowercase. If there are
     * duplicates, only one copy of that word will be kept in the list.
     *
     * @param list The list of words that will be sorted.
     * @return A new list of words consisting of all the words in the
                list given as a parameter
     */
    private static ArrayList<String> alphabetize(ArrayList<String> list) {
    
        int numWords = list.size();
            
        // Change the case of all words in the list to lowercase.
        for (int i = 0; i < numWords; i++) {
        
            String s = list.get(i);
            if (s != null)
                s = s.toLowerCase();
            list.set(i, s);
            
        }
            
        int itemsSorted;

        for (itemsSorted = 1; itemsSorted < numWords; itemsSorted++) {
        
            int loc = itemsSorted - 1;
            
            String s1 = list.get(loc);
            String s2 = list.get(itemsSorted);
            
            // The result of comparing the two strings above.
            int comp;
            try {
                comp = s1.compareTo(s2);
            }
            catch (NullPointerException e) {
                break;
            }
            
            while (loc >= 0 && comp > 0) {
            
                list.set(loc + 1, list.get(loc));
                loc -= 1;
                
                if (loc >= 0)
                    s1 = list.get(loc);
                    
                comp = s1.compareTo(s2);
            
            }
            
            list.set(loc + 1, s2);
        
        } // end for
        
        return list;
    
    } // end alphabetize()
    
    private static ArrayList<String> removeDuplicates(ArrayList<String> list) {
    
        int numWords = list.size();
        
        for (int i = 0; i < numWords - 1; i++) {
        
            String s1 = list.get(i);
            String s2 = list.get(i + 1);
            
            while (s1.equals(s2)) {
            
                list.remove(i + 1);
                numWords--;
                
                s2 = list.get(i + 1);
                
            } // end while
        
        } // end for
        
        return list;
    
    } // end removeDuplicates()

    public static void main(String[] args) {
    
        System.out.println("\n\tWhich file do you want to process? ");
        TextIO.readUserSelectedFile();
        
        ArrayList<String> wordList = new ArrayList<String>();
        String word = "";
        
        while (word != null) {
        
            word = readNextWord();
            wordList.add(word);
            
        }
        
        wordList = alphabetize(wordList);
        wordList = removeDuplicates(wordList);
        
        System.out.println("\n\tStore the file.");
        
        TextIO.writeUserSelectedFile();
        
        for (String w: wordList)
            if (w != null)
                TextIO.putln(w);
            
        TextIO.writeStandardOutput();
        
        System.out.println("\n\tProcessing done!");
    
    } // end main()

} // end class ListWords

