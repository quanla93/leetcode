package daily;

public class day_9_1_2025 {

    public static void main(String[] args) {
        day_9_1_2025 test = new day_9_1_2025();
        String[] words = {"apple", "banana", "apricot", "avocado", "blueberry", "blackberry", "cherry", "cranberry", "date", "elderberry"};
        System.out.println(test.prefixCount(words, "ap"));
        String[] words2 = {"leetcode","win","loops","success"};
        System.out.println(test.prefixCount(words2, "code"));
    }

    /**
     *
     * 2185. Counting Words With a Given Prefix
     *
     * You are given an array of strings words and a string pref.
     * Return the number of strings in words that contain pref as a prefix.
     * A prefix of a string s is any leading contiguous substring of s.
     *
     * @param words
     * @param pref
     * @return
     */
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
