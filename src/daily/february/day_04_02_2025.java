package daily.february;

public class day_04_02_2025 {

    public static void main(String[] args) {
        day_04_02_2025 obj = new day_04_02_2025();
        System.out.println(obj.maxAscendingSum(new int[] {10, 20, 30, 5, 10, 50})); // Output: 65
        System.out.println(obj.maxAscendingSum(new int[] {10, 20, 30, 40, 50})); // Output: 150
        System.out.println(obj.maxAscendingSum(new int[] {12, 17, 15, 13, 10, 11, 12})); // Output: 33
        System.out.println(obj.maxAscendingSum(new int[] {100, 10, 1})); // Output: 100
    }

    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int inc = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc += nums[i];
            } else {
                inc = nums[i];
            }
            maxSum = Math.max(maxSum, inc);
        }
        return maxSum;
    }
}
