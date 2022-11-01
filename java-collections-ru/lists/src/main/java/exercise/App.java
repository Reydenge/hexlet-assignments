package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static List scrabble (String characters, String word) {
        List<Character> charList = new ArrayList<>();
        List<Character> wordList = new ArrayList<>();
        String char1 = characters.toLowerCase();
        String word1 = word.toLowerCase();
        int count = 0;
        for (int i = 0; i < char1.length(); i++) {
            charList.add(char1.charAt(i));
        }
        for (int j = 0; j < word1.length(); j++) {
            wordList.add(word1.charAt(j));
        }

        for (char s : wordList) {
            if (charList.contains(s)) {
                charList.remove(s);
            }
        }
        return charList;
        }

        public static void main (String[] args) {
            System.out.println(App.scrabble("thlxertwq", "hexlet"));
        }
    }


//END
