package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble (String characters, String word) {
        List<String> charList = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        String char1 = characters.toLowerCase();
        String word1 = word.toLowerCase();
        int count = 0;
        for (int i = 0; i < char1.length(); i++) {
            charList.add(String.valueOf(char1.charAt(i)));
        }
        for (int j = 0; j < word1.length(); j++) {
            wordList.add(String.valueOf(word1.charAt(j)));
        }
        int sizeOfCharList = charList.size();
        for (String s : wordList) {
            if (charList.contains(s)) {
                charList.remove(s);
            }
        }
        int diff = sizeOfCharList - charList.size();
        return word.length()==diff;
        }
    }


//END
