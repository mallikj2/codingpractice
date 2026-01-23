package org.prepare;

/**
 *
 * Write a function solution that, given two integers A and B, returns a string containing exactly A letters 'a' and exactly B letters 'b' with no three consecutive letters being the same (in other words, neither "aaa" nor "bbb" may occur in the returned string).
 *
 * Examples:
 *
 * 1. Given A = 5 and B = 3, your function may return "aabaabab". Note that "abaabbaa" would also be a correct answer. Your function may return any correct answer.
 *
 * 2. Given A = 3 and B = 3, your function should return "ababab", "aababb", "abaabb" or any of several other strings.
 *
 * 3. Given A = 1 and B = 4, your function should return "bbabb", which is the only correct answer in this case.
 *
 * Assume that:
 *
 * A and B are integers within the range [0..100];
 * at least one solution exists for the given A and B.
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 */
public class ThreeLetters {
    public String solution(int A, int B) {
        StringBuilder result = new StringBuilder();

        // Decide which character has the higher count
        char first = 'a', second = 'b';
        int count1 = A, count2 = B;
        if (B > A) {
            first = 'b';
            second = 'a';
            count1 = B;
            count2 = A;
        }

        // Generate the string ensuring no three consecutive letters
        while (count1 > 0 || count2 > 0) {
            if (count1 > count2) {
                // Add two of the character with the higher count if possible
                result.append(first);
                count1--;
                if (count1 > 0) {
                    result.append(first);
                    count1--;
                }
                // Add one of the other character if available
                if (count2 > 0) {
                    result.append(second);
                    count2--;
                }
            } else {
                // Alternate between the characters
                if (count1 > 0) {
                    result.append(first);
                    count1--;
                }
                if (count2 > 0) {
                    result.append(second);
                    count2--;
                }
            }
        }

        return result.toString();
    }

    public static void main(String... args) {
        ThreeLetters tl = new ThreeLetters();

        System.out.println("The value is ..."+ tl.solution(5,3));
        System.out.println("The value is ..."+ tl.solution(3,3));
        System.out.println("The value is ..."+ tl.solution(1,4));
    }
}
