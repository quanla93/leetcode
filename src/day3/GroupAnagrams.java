package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] str = word.toCharArray();
            Arrays.sort(str);
            String sortedStr = new String(str);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(word);
            } else {
                map.put(sortedStr, new ArrayList<>(List.of(word)));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs1 = {""};
        System.out.println(groupAnagrams.groupAnagrams(strs));
        System.out.println(groupAnagrams.groupAnagrams(strs1));
    }
}
