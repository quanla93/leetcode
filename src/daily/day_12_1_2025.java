package daily;

import java.util.ArrayList;
import java.util.List;

public class day_12_1_2025 {

    public boolean canBeValid(String s, String locked) {
        // Nếu độ dài là lẻ, không thể hợp lệ
        if (s.length() % 2 != 0) {
            return false;
        }

        // Duyệt từ trái sang phải
        int openMin = 0, openMax = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    openMin++;
                    openMax++;
                } else {
                    openMin--;
                    openMax--;
                }
            } else {
                openMin--;  // Có thể coi là ')'
                openMax++;  // Có thể coi là '('
            }

            // Nếu openMax < 0, chuỗi không hợp lệ (quá nhiều ')')
            if (openMax < 0) {
                return false;
            }

            // Đảm bảo openMin không âm
            openMin = Math.max(0, openMin);
        }

        return openMin == 0;
    }
    public static void main(String[] args) {
        day_12_1_2025 obj = new day_12_1_2025();

        // Test case 1
        String s1 = "((()(()()))()((()()))))()((()(()";
        String locked1 = "10111100100101001110100010001001";
        System.out.println(obj.canBeValid(s1, locked1)); // Expected: true

        // Test case 2
        String s2 = "())";
        String locked2 = "000";
        System.out.println(obj.canBeValid(s2, locked2)); // Output: true

        // Test case 3
        String s3 = "(()))";
        String locked3 = "11010";
        System.out.println(obj.canBeValid(s3, locked3)); // Output: false

        // Test case 4
        String s4 = "()";
        String locked4 = "11";
        System.out.println(obj.canBeValid(s4, locked4)); // Output: true

        // Test case từ người dùng
        String s = "())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(";
        String locked = "100011110110011011010111100111011101111110000101001101001111";
        System.out.println(obj.canBeValid(s, locked)); // Phải trả về false


    }
}
