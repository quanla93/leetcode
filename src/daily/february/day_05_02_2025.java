package daily.february;

public class day_05_02_2025 {

    public static void main(String[] args) {
        day_05_02_2025 obj = new day_05_02_2025();
        System.out.println(obj.areAlmostEqual("bank", "kanb")); // Output: true
        System.out.println(obj.areAlmostEqual("attack", "defend")); // Output: false
        System.out.println(obj.areAlmostEqual("kelb", "kelb")); // Output: true
        System.out.println(obj.areAlmostEqual("abcd", "dcba")); // Output: false
    }

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        // đếm số lần xuất hiêện kí tự của từng chuỗi rồi so sánh xem có bằng nhau không
        // nếu không thì return false
        // nếu bằng nhau thì kiểm tra xem có 2 kí tự khác nhau không
        // nếu có 2 kí tự khác nhau thì return true
        // nếu không có hoặc nhiều hơn 2 kí tự khác nhau thì return false

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        if (diff == 2) {
            return true;
        }

        return false;

    }
}
