package arraysAndHashing;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {3, 0, 1};
        int[] nums1 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber.missingNumber(nums));
        System.out.println(missingNumber.missingNumber(nums1));
    }
}
