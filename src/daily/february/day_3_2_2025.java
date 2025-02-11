package daily.february;

public class day_3_2_2025 {

    public int longestMonotonicSubarray(int[] nums) {
        int des = 1, inc = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                inc++;
                des = 1;
            } else if (nums[i] < nums[i-1]) {
                inc = 1;
                des++;
            } else {
                des = inc = 1;
            }
            ans = Math.max(ans, Math.max(des, inc));
        }
        return ans;
    }

    public static void main(String[] args) {
        day_3_2_2025 obj = new day_3_2_2025();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(obj.longestMonotonicSubarray(nums));
        int[] nums2 = {1,4,3,3,2};
        System.out.println(obj.longestMonotonicSubarray(nums2));
        int[] nums3 = {1};
        System.out.println(obj.longestMonotonicSubarray(nums3));
    }
}
