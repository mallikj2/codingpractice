package org.prepare.codality.lessons.sorting;


import java.util.Arrays;

/**
 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
 *
 * For example, array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * contains the following example triplets:
 *
 * (0, 1, 2), product is −3 * 1 * 2 = −6
 * (1, 2, 4), product is 1 * 2 * 5 = 10
 * (2, 4, 5), product is 2 * 5 * 6 = 60
 * Your goal is to find the maximal product of any triplet.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given a non-empty array A, returns the value of the maximal product of any triplet.
 *
 * For example, given array A such that:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * the function should return 60, as the product of triplet (2, 4, 5) is maximal.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [3..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 *
 */

public class MaxProductOfThree {

    public int solution(int[] A) {
        int n = A.length;
        // Sort the array to easily find the largest and smallest elements
        Arrays.sort(A);

        // Calculate two possible maximum products:
        // 1. Product of three largest elements
        int maxProduct1 = A[n-1] * A[n-2] * A[n-3];

        // 2. Product of two smallest elements (potentially negative) and the largest element
        int maxProduct2 = A[0] * A[1] * A[n-1];

        // Return the maximum of these two products
        return Math.max(maxProduct1, maxProduct2);
    }

    public static void main(String... args){
        MaxProductOfThree mpt = new MaxProductOfThree();

        System.out.println("The value is ..."+ mpt.solution(new int[] {-3,1,2,-2,5,6}));
    }
}
