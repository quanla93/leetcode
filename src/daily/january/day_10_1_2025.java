package daily.january;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day_10_1_2025 {
    public static void main(String[] args) {
        day_10_1_2025 obj = new day_10_1_2025();
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        System.out.println(obj.wordSubsets(words1, words2)); // [facebook, google, leetcode]

    }

    /**
     * 916. Word Subsets
     * You are given two string arrays words1 and words2.
     *
     * A string b is a subset of string a if every letter in b occurs in a including multiplicity.
     *
     * For example, "wrr" is a subset of "warrior" but is not a subset of "world".
     * A string a from words1 is universal if for every string b in words2, b is a subset of a.
     *
     * Return an array of all the universal strings in words1. You may return the answer in any order.
     *
     * @param words1
     * @param words2
     * @return
     */
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Check char frequency of each word in words2
        Map<Character, Integer> charMaxFrequency = new HashMap<>();
        for (String string : words2) {
            Map<Character, Integer> map = getCharFrequency(string);
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                charMaxFrequency.put(entry.getKey(), Math.max(charMaxFrequency.getOrDefault(entry.getKey(), 0), entry.getValue()));
            }
        }

        List<String> result = new ArrayList<>();
        // Check if each word in words1 is a subset of words2
        for (String string : words1) {
            Map<Character, Integer> map = getCharFrequency(string);
            if (isUniversal(charMaxFrequency, map)) {
                result.add(string);
            }
        }
        return result;
    }

    private Map<Character, Integer> getCharFrequency(String word) {
       Map<Character, Integer> map = new HashMap<>();
       for (char ch : word.toCharArray()) {
           map.put(ch, map.getOrDefault(ch, 0) + 1);
       }
       return map;
    }

    private boolean isUniversal(Map<Character, Integer> charMaxFrequency, Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : charMaxFrequency.entrySet()) {
            if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Cách 2
     */
    public List<String> wordSubsetsV2(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word: words2) {
            int[] freq = getCharFreq(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word: words1) {
            int[] freq = getCharFreq(word);
            if (isUniversalV2(maxFreq, freq)) {
                result.add(word);
            }
        }
        return result;
    }

    private int[] getCharFreq(String word) {
        // Word1 and word2 are lowercase and english letter
        // English letter has 26 characters
        int[] freq = new int[26];
        for (char ch: word.toCharArray()) {
            // 'a' -> 0, 'b' -> 1, 'c' -> 2, ...
            freq[ch - 'a']++;
        }
        return freq;
    }

    private boolean isUniversalV2(int[] maxFreq, int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
