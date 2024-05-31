package arraysAndHashing;

import java.util.HashMap;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int index = nums.length - 1; index >= 0; --index) {
            for (int i = 0; i < index; ++i) {
                if (nums[i] == nums[index] && Math.abs(index - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int index = nums.length - 1; index >= 0; --index) {
            if (set.containsKey(nums[index]) && Math.abs(set.get(nums[index]) - index) <= k) {
                return true;
            }
            set.put(nums[index], index);
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
        int[] nums = {1, 2, 3, 1};
        int[] nums1 = {1, 0, 1, 1};
        int[] nums2 = {1, 2, 3, 1, 2, 3};
        int[] nums3 = {0,1,2,3,4,0,0,7,8,9,10,11,12,0};

        int k = 3;
        int k1 = 1;
        int k3 = 1;
        int k2 = 2;
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums, k));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums1, k1));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums2, k2));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicate(nums3, k3));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicateV2(nums, k));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicateV2(nums1, k1));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicateV2(nums2, k2));
        System.out.println(containsNearbyDuplicate.containsNearbyDuplicateV2(nums3, k3));
    }
}
