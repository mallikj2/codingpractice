package org.prepare.codality.lessons.countingElements;

import java.util.HashSet;

/***
 *
 * Write a function:
 * class Solution { public int solution(int[] A); }
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000]; each element of array A is an integer within the range [−1,000,000..1,000,000].
 *
 */
public class MissingNumber {
    public static int solution(int[] A) {
        // Create a HashSet to store all positive integers in the array
        HashSet<Integer> positiveNumbers = new HashSet<>();

        // Add all positive integers from the array into the HashSet
        for (int num : A) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        // Check for the smallest positive integer that is not in the HashSet
        int smallestPositive = 1;
        while (positiveNumbers.contains(smallestPositive)) {
            smallestPositive++;
        }

        return smallestPositive; // Return the result
    }

    public static void main(String[] args) {
        System.out.println("The Missing smallest positive number is ..."+solution(new int[] {1, 3, 6, 4, 1, 2}));
    }

}
