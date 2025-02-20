package daily.january;

public class day_16_1_2025 {

    public int xorAllNums(int[] nums1, int[] nums2) {
        int xorNums1 = 0;
        int xorNums2 = 0;

        // Tính XOR của tất cả phần tử trong nums1
        for (int num : nums1) {
            xorNums1 ^= num;
        }

        // Tính XOR của tất cả phần tử trong nums2
        for (int num : nums2) {
            xorNums2 ^= num;
        }

        int result = 0;
        if (nums1.length % 2 == 1) {
            result ^= xorNums2;
        }
        if (nums2.length % 2 == 1) {
            result ^= xorNums1;
        }

        // Kết quả cuối cùng
        return result;
    }

    public static void main(String[] args) {
        day_16_1_2025 obj = new day_16_1_2025();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(obj.xorAllNums(nums1, nums2));  // Output: 2

        int[] nums1_2 = {2, 1, 3};
        int[] nums2_2 = {10, 2, 5, 0};
        System.out.println(obj.xorAllNums(nums1_2, nums2_2));  // Output: 13
    }
}
