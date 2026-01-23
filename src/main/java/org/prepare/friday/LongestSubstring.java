package org.prepare.friday;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to find the longest substring without repeating characters.
 *
 */

public class LongestSubstring {
    public static void main(String[] args) {
        String input = "abcabbwnhjhuchj";
        int length = lengthOfLongestSubstring(input);
        System.out.println("The length of the longest substring without repeating characters is: " + length);
    }

    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
        int maxLength =0;
        int left =0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for(int right=0; right <s.length(); right++){
            Character currentChar = s.charAt(right);
            if(charIndexMap.containsKey(currentChar)){
                left = Math.max(charIndexMap.get(currentChar)+1, left);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left +1);
        }
        return maxLength;
    }

    public static String longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, maxLen = 0, startIndex = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate found, move left pointer
            if (seen.containsKey(c) && seen.get(c) >= left) {
                left = seen.get(c) + 1;
            }

            seen.put(c, right);

            int windowLen = right - left + 1;
            if (windowLen > maxLen) {
                maxLen = windowLen;
                startIndex = left;
            }
        }

        return s.substring(startIndex, startIndex + maxLen);
    }

}
