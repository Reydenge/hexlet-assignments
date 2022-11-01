package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble (String characters, String word) {
        String[] char1 = characters.toLowerCase().split("");
        ArrayList<String> charList = new ArrayList<>(Arrays.asList(char1));
        String[] word1 = word.toLowerCase().split("");
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList(word1));
        for (String s : wordList) {
            if (!charList.contains(s)) {
                return false;
            }
            charList.remove(s);
        }
        return true;
        }
    }


//END
