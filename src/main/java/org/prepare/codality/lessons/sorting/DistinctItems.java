package org.prepare.codality.lessons.sorting;

import java.util.HashSet;

/**
 * Write a function
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A consisting of N integers, returns the number of distinct values in array A.
 *
 * For example, given array A consisting of six elements such that:
 *
 *  A[0] = 2    A[1] = 1    A[2] = 1
 *  A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class DistinctItems {
    public int solution(int[] A) {
        HashSet<Integer> distinctValues = new HashSet<>();

        for(int val: A){
            distinctValues.add(val);
        }

        return distinctValues.size();
    }

    public static void main(String[] args) {
        DistinctItems di = new DistinctItems();

        System.out.println("The distinct size is ..."+ di.solution(new int[] {2,1,1,2,3,1}));
    }
}
