package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordsMap = new HashMap<String, Integer>();
        String[] wordsFromSentence = sentence.split(" ");
        if (sentence.length() == 0) {
            return wordsMap;
        }
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
        if (wordsMap.isEmpty()) {
            return "{}";
        }
        StringBuilder result = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> pair : wordsMap.entrySet()) {
            result = result.append("  " + pair.getKey() + ": " + pair.getValue() + "\n");
            }
        String result2 = String.valueOf(result.append("}"));
        return result2;
        }


        public static void main (String[] args) {
            String sentence1 = "word text cat apple word map apple word";
            Map s1 = App.getWordCount(sentence1);
            String s2 = App.toString(s1);
            System.out.println(s2);
        }
    }
//END
