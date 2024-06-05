package arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class nextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int j = 0;
            while (nums1[i] != nums2[j]) {
                j++;
            }
            while (j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    result[i] = nums2[j];
                    break;
                }
                j++;
            }
            if (j == nums2.length) {
                result[i] = -1;
            }
        }
        return result;
    }

    public int[] nextGreaterElementV2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int j = i + 1;
            int max = nums2[i];
            while (j < nums2.length) {
                if (nums2[j] > max) {
                    max = nums2[j];
                    break;
                }
                j++;
            }
            if (max != nums2[i]) {
                map.put(nums2[i], max);
            } else {
                map.put(nums2[i], -1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        nextGreaterElement nextGreaterElement = new nextGreaterElement();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElementV2(nums1, nums2)));
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElementV2(nums3, nums4)));
    }
}
