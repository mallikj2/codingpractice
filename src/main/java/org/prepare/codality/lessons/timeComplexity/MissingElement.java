package org.prepare.codality.lessons.timeComplexity;

/**
 *
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 *
 */

public class MissingElement {
    public static int solution(int[] A) {
        int N= A.length;

        // Calculate the expected sum of the first N + 1 natural numbers
        long expectedSum = (long) (N + 1) * (N + 2) / 2;

        // Calculate the actual sum of the array elements
        long actualSum = 0;
        for (int num : A) {
            actualSum += num;
        }

        // The missing element is the difference between the expected sum and the actual sum
        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        MissingElement missingElement = new MissingElement();

        // Example array
        int[] array = {2, 3, 1, 5};

        // Print the result
        System.out.println("Missing Element: " + missingElement.solution(array));
    }

}
