package daily.january;

public class day_11_1_2025 {

    public static void main(String[] args) {
        day_11_1_2025 obj = new day_11_1_2025();
        System.out.println(obj.canConstruct("annabelle", 2));
        System.out.println(obj.canConstruct("leetcode", 3));
        System.out.println(obj.canConstruct("true", 4));
        System.out.println(obj.canConstruct("cr", 4));
        System.out.println(obj.canConstruct("putmeinatrouble", 16));
    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        int[] countChar = new int[26];
        for (char ch: s.toCharArray()) {
            countChar[ch - 'a']++;
        }

        int odd_count = 0;
        for (int i = 0; i < countChar.length; i++ ) {
            if (countChar[i] % 2 != 0) {
                odd_count++;
            }
        }
        return odd_count <= k;
    }
}
