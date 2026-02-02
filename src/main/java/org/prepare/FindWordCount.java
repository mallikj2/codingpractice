package org.prepare;

import java.util.List;

public class FindWordCount {


    /**
     * Write a method to find the count of same words in a given list of words,
     * And sort them by desc and return the list.
     */
    public static void findWordCountDesc(List<String> words) {
        java.util.Map<String, Long> wordCount = words.stream()
                .collect(java.util.stream.Collectors.groupingBy(w -> w, java.util.stream.Collectors.counting()));

        wordCount.entrySet().stream()
                .sorted(java.util.Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    /**
     * Write a method to find the count of same words in a given list of words,
     * And sort them by desc and return the list. don't use stream api.
     */
    public static void findWordCountDescNoStream(List<String> words) {
        java.util.Map<String, Long> wordCount = new java.util.HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1);
        }

        List<java.util.Map.Entry<String, Long>> entryList = new java.util.ArrayList<>(wordCount.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (java.util.Map.Entry<String, Long> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    // new: return entries sorted by count ascending using streams
    public static List<java.util.Map.Entry<String, Long>> findWordCountAsc(List<String> words) {
        java.util.Map<String, Long> wordCount = words.stream()
                .collect(java.util.stream.Collectors.groupingBy(w -> w, java.util.stream.Collectors.counting()));

        return wordCount.entrySet().stream()
                .sorted(java.util.Map.Entry.comparingByValue())
                .collect(java.util.stream.Collectors.toList());
    }

    // new: same as above without streams
    public static List<java.util.Map.Entry<String, Long>> findWordCountAscNoStream(List<String> words) {
        java.util.Map<String, Long> wordCount = new java.util.HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1);
        }

        List<java.util.Map.Entry<String, Long>> entryList = new java.util.ArrayList<>(wordCount.entrySet());
        entryList.sort((e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        return entryList;
    }

    // new: same as above but input is a paragraph string.
    public static void findWordCountInParagraph(String paragraph) {
        String[] wordsArray = paragraph.split("\\W+");
        List<String> words = java.util.Arrays.asList(wordsArray);

        java.util.Map<String, Long> wordCount = words.stream()
                .collect(java.util.stream.Collectors.groupingBy(w -> w, java.util.stream.Collectors.counting()));

        wordCount.entrySet().stream()
                .sorted(java.util.Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    /**
     * Write a method to find the count of same words in a given list of words,
     * And sort them by asc and return the list.
     *
     */
    public  static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

        java.util.Map<String, Long> wordCount = words.stream()
                .collect(java.util.stream.Collectors.groupingBy(w -> w, java.util.stream.Collectors.counting()));

        wordCount.entrySet().stream()
                .sorted(java.util.Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("With Stream API:");
        findWordCountDesc(words);
        System.out.println("Without Stream API:");
        findWordCountDescNoStream(words);

        System.out.println("With Stream API Ascending:");
        findWordCountAsc(words).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("Without Stream API Ascending:");
        findWordCountAscNoStream(words).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("Word count in paragraph:");
        String paragraph = "This is a test. This test is only a test.";
        findWordCountInParagraph(paragraph);
    }
}
