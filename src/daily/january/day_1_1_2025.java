package daily.january;

import java.util.Arrays;

public class day_1_1_2025 {

    public static void main(String[] args) {
        day_1_1_2025 obj = new day_1_1_2025();

        Runtime runtime = Runtime.getRuntime();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();
        System.out.println(obj.maxScore("1111"));
        System.out.println(runtime.totalMemory() - runtime.freeMemory() - memory + "bytes");
        System.out.println(System.currentTimeMillis() - startTime + "ms");



        System.out.println(obj.maxScore("011101"));
        System.out.println(obj.maxScore("00111"));

        System.out.println(obj.maxScoreV2("1111"));
        System.out.println(obj.maxScoreV2("011101"));

    }

    public int maxScore(String s) {
        int max = 0;
        for (int i = 0; s.length() - 1 > i; i++) {
            String leftString = s.substring(0, i + 1);
            String rightString = s.substring(i + 1);
            int totalLeft = (int) leftString.chars().filter(ch -> ch == '0').count();
            int totalRight = (int) rightString.chars().filter(ch -> ch == '1').count();
            max = Math.max(max, totalLeft + totalRight);
        }
        return max;
    }

    /**
     * Duyệt qua chuỗi, đếm số lượng số 0 và số 1, sau đó cập nhật giá trị max
     *
     * @param s
     * @return
     */
    public int maxScoreV2(String s) {
        int n = s.length();
        int zeros = 0, ones = 0, max = 0;
        // Đếm số lượng số 1
        // Sau đó duyệt qua chuỗi, nếu là số 1 thì tăng biến ones lên 1
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        // Duyệt qua chuỗi, nếu là số 0 thì tăng biến zeros lên 1, ngược lại giảm biến ones
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }
            max = Math.max(max, zeros + ones);
        }

        return max;
    }

    public boolean checkInstance(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return false;
        }

        String[] strings = s.split("");
        return Arrays.stream(strings).noneMatch(string -> !string.equals("0") && !string.equals("1"));
    }
}
