package daily.january;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class day_7_1_2025 {

    public static void main(String[] args) {
        day_7_1_2025 obj = new day_7_1_2025();
        String[] words = {"mass", "as", "hero", "superhero", "he", "her"};
        String[] wordsV2 = {"leetcode","et","code"};
        System.out.println(obj.stringMatching(words));
        System.out.println(obj.stringMatching(wordsV2));
    }

    /**
     *
     * 1408. String Matching in an Array
     *
     * Given an array of string words. Return all strings in words which is substring of another word in any order.
     *
     * String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
     *
     * @param words
     * @return
     */
    public List<String> stringMatching(String[] words) {
        // sort the array by length
        Set<String> set = Set.of(words);
        List<String> result = new ArrayList<>();
        set.forEach(word -> {
            for (String s : words) {
                if (s.length() > word.length()) {
                    if (s.contains(word)) {
                        result.add(word);
                        break;
                    }
                }
            }
        });
        return result;
    }
}
