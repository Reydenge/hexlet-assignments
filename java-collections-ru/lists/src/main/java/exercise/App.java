package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble (String characters, String word) {
        String[] char1 = characters.toLowerCase().split("");
        ArrayList charList = new ArrayList(Arrays.asList(char1));
        String[] word1 = word.toLowerCase().split("");
        ArrayList wordList = new ArrayList(Arrays.asList(word1));
        for (Object s : wordList) {
            if (!charList.contains(s)) {
                return false;
            }
            charList.remove(s);
        }
        return true;
        }
    }


//END
