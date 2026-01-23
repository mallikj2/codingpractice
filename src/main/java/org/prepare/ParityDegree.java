package org.prepare;

/**
 *
 * A positive integer N is given. The goal is to find the highest power of 2 that divides N. In other words, we have to find the maximum K for which N modulo 2^K is 0.
 * For example, given integer N = 24 the answer is 3, because 2^3 = 8 is the highest power of 2 that divides N.
 * Write a function:
 * class Solution { public int solution(int N); }
 * that, given a positive integer N, returns the highest power of 2 that divides N.
 * For example, given integer N = 24, the function should return 3, as explained above.
 * Assume that:
 * N is an integer within the range [1..1,000,000,000]. In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 *
 */
public class ParityDegree {

    public int solution(int N) {
        int power = 0;

        // While N is divisible by 2, keep dividing it and increment the power
        while (N % 2 == 0) {
            N /= 2;
            power++;
        }

        return power;
    }

    public static void main(String... args){
        ParityDegree pd = new ParityDegree();

        System.out.println("The highest power value is ..."+pd.solution(24));
    }
}
