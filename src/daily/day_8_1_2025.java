package daily;

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
