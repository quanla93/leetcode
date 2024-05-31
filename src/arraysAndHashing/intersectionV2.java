package arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class intersectionV2 {

    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int value : nums1) {
            result.put(value, result.getOrDefault(value, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int j : nums2) {
            if (result.containsKey(j) && result.get(j) > 0) {
                list.add(j);
                result.put(j, result.get(j) - 1);
            }
        }

        int[] finalResult = new int[list.size()];
        int i = 0;
        for (Integer entry : list) {
            finalResult[i] = entry;
            i++;
        }

        return finalResult;

    }


    public static void main(String[] args) {
        intersectionV2 intersection = new intersectionV2();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection.intersectionV2(nums1, nums2)));
        System.out.println(Arrays.toString(intersection.intersectionV2(nums3, nums4)));
    }
}
