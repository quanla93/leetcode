package daily;

public class day_13_1_2025 {

    public int minimumLength(String s) {
        int[] req = new int[26];
        for (char ch: s.toCharArray()) {
            req[ch - 'a']++;
        }
        int result = 0;
        if (s.length() <= 2) {
            return s.length();
        }
        for (int i = 0; i < 26; i++) {
            if (req[i] > 0) {
                if (req[i] % 2 == 0) {
                    result += 2;
                } else {
                    result++;
                }
            }
        }
        return result;
    }

//    public int minimumLength(String s) {
//        int left = 0;
//        int right = s.length() - 1;
//
//        char[] str = s.toCharArray();
//        // Process until the valid range shrinks
//        while (left < right) {
//            // Try to find the closest matching characters on both sides
//            int tempLeft = left + 1;
//            int tempRight = right - 1;
//
//            // Move left pointer towards the next character
//            while (tempLeft < right && str[tempLeft] != str[left]) {
//                tempLeft++;
//            }
//
//            // Move right pointer towards the previous character
//            while (tempRight > left && str[tempRight] != str[right]) {
//                tempRight--;
//            }
//
//            // If we found a match on both sides, perform the deletion
//            if (tempLeft < right && tempRight > left) {
//                str[left] = str[right] = ' ';  // Mark characters for removal
//                left++;
//                right--;
//            } else {
//                break;  // No more deletions possible
//            }
//        }
//
//        return right - left + 1;
//    }

    public static void main(String[] args) {
        day_13_1_2025 obj = new day_13_1_2025();
        System.out.println(obj.minimumLength("abaacbcbb"));
        System.out.println(obj.minimumLength("caabbacc"));
    }
}
