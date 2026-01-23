package org.prepare.codality.lessons.prefixsums;

import java.util.Arrays;

/**
 *
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?
 *
 * The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).
 *
 * For example, consider string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * The answers to these M = 3 queries are as follows:
 *
 * The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
 * The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
 * The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
 * Write a function:
 *
 * class Solution { public int[] solution(String S, int[] P, int[] Q); }
 *
 * that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.
 *
 * Result array should be returned as an array of integers.
 *
 * For example, given the string S = CAGCCTA and arrays P, Q such that:
 *
 *     P[0] = 2    Q[0] = 4
 *     P[1] = 5    Q[1] = 5
 *     P[2] = 0    Q[2] = 6
 * the function should return the values [2, 4, 1], as explained above.
 *
 * Write an efficient algorithm for the following assumptions:
 *
 * N is an integer within the range [1..100,000];
 * M is an integer within the range [1..50,000];
 * each element of arrays P and Q is an integer within the range [0..N - 1];
 * P[K] ≤ Q[K], where 0 ≤ K < M;
 * string S consists only of upper-case English letters A, C, G, T.
 *
 */
public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q){
        int N = S.length();
        int M = P.length;

        // Prefix sums for nucleotides A, C, G
        int[][] prefixSums = new int[3][N + 1];
        for (int i = 0; i < N; i++) {
            char nucleotide = S.charAt(i);
            prefixSums[0][i + 1] = prefixSums[0][i] + (nucleotide == 'A' ? 1 : 0);
            prefixSums[1][i + 1] = prefixSums[1][i] + (nucleotide == 'C' ? 1 : 0);
            prefixSums[2][i + 1] = prefixSums[2][i] + (nucleotide == 'G' ? 1 : 0);
        }

        int[] results = new int[M];
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1;

            if (prefixSums[0][end] - prefixSums[0][start] > 0) {
                results[k] = 1; // 'A' has the minimal impact factor of 1
            } else if (prefixSums[1][end] - prefixSums[1][start] > 0) {
                results[k] = 2; // 'C' has the minimal impact factor of 2
            } else if (prefixSums[2][end] - prefixSums[2][start] > 0) {
                results[k] = 3; // 'G' has the minimal impact factor of 3
            } else {
                results[k] = 4; // 'T' has the impact factor of 4
            }
        }

        return results;
    }

    public static void main(String... args) {
        GenomicRangeQuery grq= new GenomicRangeQuery();

        System.out.println("The result is ..."+ Arrays.toString(grq.solution("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6})));
    }
}
