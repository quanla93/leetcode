package arraysAndHashing;

import java.util.Arrays;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        if (new String(s1).equals(new String(t1))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagramV2("anagram", "nagaram"));
        System.out.println(isAnagram.isAnagram("rat", "car"));
        System.out.println(isAnagram.isAnagramV2("rat", "car"));
    }

}
