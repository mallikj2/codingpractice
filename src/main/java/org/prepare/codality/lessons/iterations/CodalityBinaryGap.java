package org.prepare.codality.lessons.iterations;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CodalityBinaryGap {

    public static int solution(int N) {
        // Convert the number to its binary representation as a string
        String binary = Integer.toBinaryString(N);
        // Initialize the maximum binary gap length and the current gap length
        int maxGap = 0;
        int currentGap = 0;

        // Traverse the binary representation character by character
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                // If we encounter a '1', update the maximum gap length
                maxGap = Math.max(maxGap, currentGap);
                // Reset the current gap length
                currentGap = 0;
            } else {
                // If we encounter a '0', increment the current gap length
                currentGap++;
            }
        }

        return maxGap; // Return the longest binary gap found
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        System.out.println("The value is.... " + solution(15));
    }
}