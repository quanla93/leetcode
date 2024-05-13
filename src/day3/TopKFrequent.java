package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(
                e -> {
                    list.add(e.getKey());
                });

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums1 = {4,1,-1,2,-1,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums, k)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(nums1, k)));
    }
}
