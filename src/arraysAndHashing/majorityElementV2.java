package arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class majorityElementV2 {

    //Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length/3;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(e -> e.getValue() > n).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        majorityElementV2 majorityElement = new majorityElementV2();
        int[] nums = {3, 2, 3};
        int[] nums1 = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(majorityElement.majorityElement(nums));
        System.out.println(majorityElement.majorityElement(nums1));
    }
}
