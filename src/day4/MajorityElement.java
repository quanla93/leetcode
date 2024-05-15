package day4;

import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3, 2, 3};
        int[] nums1 = {2, 2, 1, 1, 1, 2, 2};
        int[] nums2 = {1, 1, 1, 1, 1, 2, 2};
        System.out.println(majorityElement.majorityElement(nums));
        System.out.println(majorityElement.majorityElement(nums1));
        System.out.println(majorityElement.majorityElement(nums2));
    }
}
