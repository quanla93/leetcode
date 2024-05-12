package day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class longestCommonPrefix {

    //wrong
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return "";
    }

    public String longestCommonPrefixV2(String[] strs) {
        if (strs.length < 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String string1 = strs[0];
        String prefix = "";
        String result = "";
        for (int i = 0; i < string1.length(); i++) {
            prefix = string1.substring(0, i + 1);
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].indexOf(prefix) == string1.indexOf(prefix)) {
                    count++;
                }
            }
            if (count == strs.length) {
                 result = prefix;
            }
        }
        return result;
    }

    //fastest
    public String longestCommonPrefixV3(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            } else {
                sb.append(first.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        longestCommonPrefix longestCommonPrefix = new longestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flower", "flower"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV2(new String[]{"flower", "flower", "flower"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV2(new String[]{"flower", "flaaa", "flobb"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV2(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV2(new String[]{"a"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV3(new String[]{"flower", "flower", "flower"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV3(new String[]{"flower", "flaaa", "flobb"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV3(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefixV3(new String[]{"a"}));

    }
}
