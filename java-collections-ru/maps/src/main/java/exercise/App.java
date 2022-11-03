package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        String[] wordsFromSentence = sentence.split(" ");
        for (String pair : wordsFromSentence) {
            int count = 0;
            for (String s : wordsFromSentence) {
                if (pair.equals(s)) {
                    count++;
                }
                wordsMap.put(pair, count);
            }
        }
        return wordsMap;
    }

    public static String toString(Map<String, Integer> wordsMap) {
        String[] s0 = new String[wordsMap.size()];
        for (Map.Entry<String, Integer> pair : wordsMap.entrySet()) {
            for (int i = 0; i < s0.length; i++) {
                StringBuilder s1 = new StringBuilder(pair.getKey() + ": ");
                s0[i] = "  " + s1.append(pair.getValue());
            }
        }
        return Arrays.toString(s0);
    }
}
//END
