package daily;

import java.util.ArrayList;
import java.util.Arrays;
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
