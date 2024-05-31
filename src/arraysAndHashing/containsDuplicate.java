package arraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsDuplicate {

    // fastest when using set
    public boolean containsDuplicateV2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) { // set not have duplicate value
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.putIfAbsent(num, num);
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicate containsDuplicate = new containsDuplicate();
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate.containsDuplicate(nums));
        System.out.println(containsDuplicate.containsDuplicateV2(nums));
        System.out.println(containsDuplicate.containsDuplicateV2(nums1));
    }

}
