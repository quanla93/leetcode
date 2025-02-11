package daily.january;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day_14_1_2025 {
    public static void main(String[] args) {
        day_14_1_2025 obj = new day_14_1_2025();
        int[] A = {2, 1, 3, 4, 5};
        int[] B = {1, 2, 3, 4, 5};
        System.out.println(obj.findThePrefixCommonArray(A, B).toString());
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] result = new int[A.length];
        Map<Integer, Integer> countPrefixToIndex = new HashMap<>();
        int i = 0;
        int count = 0;
        while (i < A.length && i < B.length) {
            countPrefixToIndex.put(A[i], countPrefixToIndex.getOrDefault(A[i], 0) + 1);
            countPrefixToIndex.put(B[i], countPrefixToIndex.getOrDefault(B[i], 0) + 1);
            // Map:
            // 1 -> 1
            // 3 -> 1
            for (Map.Entry<Integer, Integer> entry : countPrefixToIndex.entrySet()) {
                if (entry.getValue() > 1) {
                    count+=1;
                }
            }
            result[i] = count;
            i++;
        }

        return result;
    }

    public int[] findThePrefixCommonArrayV2(int[] A, int[] B) {
        int[] result = new int[A.length];
        Set<Integer> prefixA = new HashSet<>();
        Set<Integer> prefixB = new HashSet<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (!prefixA.contains(A[i])) {
                prefixA.add(A[i]);
                if (prefixB.contains(A[i])) {
                    count++;
                }
            }


            if (!prefixB.contains(B[i])) {
                prefixB.add(B[i]);
                if (prefixA.contains(B[i])) {
                    count++;

                }
            }
            result[i] = count;
        }
        return result;
    }
}
