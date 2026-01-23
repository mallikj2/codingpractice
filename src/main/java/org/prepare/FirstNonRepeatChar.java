package org.prepare;

public class FirstNonRepeatChar {

    public int findNonRepeatCharIdx(String st){
        int[] charCount = new int[256]; // Assuming ASCII character set

        // First pass: count occurrences of each character
        for (int i = 0; i < st.length(); i++) {
            charCount[st.charAt(i)]++;
        }

        // Second pass: find the first non-repeating character
        for (int i = 0; i < st.length(); i++) {
            if (charCount[st.charAt(i)] == 1) {
                return i; // Return the index of the first non-repeating character
            }
        }

        return -1; // Return -1 if there is no non-repeating character
    }

    // Using JDK17 feature to redefine above method with Streams
    public int findNonRepeatCharIdxWithStreams(String st) {
        var charCount = st.chars()
                .boxed()
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting()));

        return st.chars()
                .boxed()
                .filter(c -> charCount.get(c) == 1)
                .mapToInt(c -> st.indexOf(c))
                .findFirst()
                .orElse(-1);
    }


    public static void main(String[] args) {
        System.out.println("The value is : " + new FirstNonRepeatChar().findNonRepeatCharIdxWithStreams("swiss"));
    }
}
