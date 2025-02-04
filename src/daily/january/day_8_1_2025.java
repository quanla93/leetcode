package daily.january;

public class day_8_1_2025 {

    public static void main(String[] args) {

        day_8_1_2025 obj = new day_8_1_2025();
        String[] words = {"a","aba","ababa","aa"};
        System.out.println(obj.countPrefixSuffixPairs(words));
        String[] wordsV2 = {"mass", "as", "hero", "superhero", "he", "her"};
        System.out.println(obj.countPrefixSuffixPairs(wordsV2));
        String[] wordsV3 = {"leetcode","et","code"};
        System.out.println(obj.countPrefixSuffixPairs(wordsV3));
        String[] wordsV4 = {"abab","ab"};
        System.out.println(obj.countPrefixSuffixPairs(wordsV4));
    }

    /**
     *
     * 3042. Count Prefix and Suffix Pairs I
     *
     * You are given a 0-indexed string array words.
     *
     * Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
     *
     * isPrefixAndSuffix(str1, str2) returns true if str1 is both a
     * prefix
     *  and a
     * suffix
     *  of str2, and false otherwise.
     * For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
     *
     * Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.
     *
     * @param words
     * @return
     */
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i < j) {
                   if (isPrefixAndSuffix(words[j], words[i])) {
                       count++;
                   }
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String word1, String word2) {
        return word1.startsWith(word2) && word1.endsWith(word2);
    }
}
