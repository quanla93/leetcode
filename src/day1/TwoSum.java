package day1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    protected int[] twoSumV1(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i) {
            int first = nums[i];
            int second = target - first;

            for(int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == second) {
                    System.out.println("[" + i + ", " + j + "]");
                    return new int[]{i, j};
                }
            }
        }

        return nums;
    }

    protected int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        int i;
        int second;
        for(i = 0; i < nums.length; ++i) {
            second = nums[i];
            map.put(second, i);
        }

        for(i = 0; i < nums.length; ++i) {
            second = target - nums[i];
            if (map.containsKey(second) && (Integer)map.get(second) != i) {
                return new int[]{i, (Integer)map.get(second)};
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        twoSum.twoSumV1(nums, target);
        twoSum.twoSumV2(nums, target);
    }

}
