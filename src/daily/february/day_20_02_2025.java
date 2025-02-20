package daily.february;

import java.util.HashSet;

public class day_20_02_2025 {

    public static void main(String[] args) {

    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Nếu nums[i][i] là '0', ta chọn '1', ngược lại chọn '0'
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return result.toString();
    }
}
