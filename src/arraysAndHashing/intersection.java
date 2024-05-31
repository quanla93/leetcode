package arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class intersection {

    public int[] intersectionV1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[k] = nums1[i];
                    k++;
                    break;
                }
            }
        }
        int[] finalResult = new int[k];
        for (int i = 0; i < k; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }

    public int[] intersectionV2(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> result = new HashMap<>();
        int k = 0;
        for (int value : nums1) {
            result.putIfAbsent(value, false);
        }

        for (int j : nums2) {
            if (result.get(j) != null && !result.get(j)) {
                result.put(j, true);
                k++;
            }
        }

        int[] finalResult = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Boolean> entry : result.entrySet()) {
            if (entry.getValue()) {
                finalResult[i] = entry.getKey();
                i++;
            }
        }

        return finalResult;

        // Set<Integer> set1 = new HashSet<>();
//         for (int n1 : nums1) {
//             set1.add(n1);
//         }
//         Set<Integer> set2 = new HashSet<>();
//         for (int n2 : nums2) {
//             if(set1.contains(n2)) {
//                 set2.add(n2);
//             }
//         }

//         int[] result = new int[set2.size()];
//         int i =0;
//         for (int x : set2) {
//             result[i] = x;
//             i++;
//         }

//         return result;
//     }

    }


    public static void main(String[] args) {
        intersection intersection = new intersection();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(intersection.intersectionV1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection.intersectionV1(nums3, nums4)));
        System.out.println(Arrays.toString(intersection.intersectionV2(nums1, nums2)));
        System.out.println(Arrays.toString(intersection.intersectionV2(nums3, nums4)));
    }
}
