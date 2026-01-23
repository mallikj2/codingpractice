package org.prepare.algoskills;

/**
 * A string S containing only the letters "A", "B" and "C" is given. The string can be transformed by removing one occurrence of "AA", "BB" or "CC".
 * Transformation of the string is the process of removing letters from it, based on the rules described above. As long as at least one rule can be applied, the process should be repeated. If more than one rule can be used, any one of them could be chosen.
 * Write a function:
 * class Solution { public String solution(String S); }
 * that, given a string S consisting of N characters, returns any string that can result from a sequence of transformations as described above.
 * For example, given string S = "ACCAABBC" the function may return "AC", because one of the possible sequences of transformations is as follows:
 * ACCAABBC -> ACCBBC -> ACCC -> AC
 * Also, given string S = "ABCBBCBA" the function may return "", because one possible sequence of transformations is:
 * ABCBBCBA -> ABCCBA -> ABBA -> AA -> ""
 * Finally, for string S = "BABABA" the function must return "BABABA", because no rules can be applied to string S.
 * Write an efficient algorithm for the following assumptions:
 * the length of string S is within the range [0..50,000]; string S is made only of the following characters: 'A', 'B' and/or 'C'.
 *
 */
public class DisappearingPairs {
    public String solution(String S) {
        // Use a StringBuilder as a stack for efficient appending and removing
        StringBuilder stack = new StringBuilder();

        for (char c : S.toCharArray()) {
            int length = stack.length();

            // Check the last character in the stack and compare with the current character
            if (length > 0 && stack.charAt(length - 1) == c) {
                // Remove the last character if it forms a pair
                stack.deleteCharAt(length - 1);
            } else {
                // Otherwise, push the current character onto the stack
                stack.append(c);
            }
        }

        // Convert the stack back to a string
        return stack.toString();
    }

    public static void main(String[] args) {
        DisappearingPairs dp = new DisappearingPairs();

        System.out.println("The Disappread value is ..."+ dp.solution("ACCAABBC"));
        System.out.println("The Disappread value is ..."+ dp.solution("ABCBBCBA"));
        System.out.println("The Disappread value is ..."+ dp.solution("BABABA"));
    }

}
