package org.prepare.friday;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class FindUniqueFromAnagram {

    // Function to find unique words in an array of words containing anagrams.
    public static void findUniqueWords(String[] words) {
        Set<String> uniqueWords = new java.util.HashSet<>();
        for(String word:words){
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            uniqueWords.add(sortedWord);
        }
        System.out.println("Unique words count (by anagram groups): " + uniqueWords.size());
        System.out.println("Unique words (by anagram groups): " + uniqueWords);
    }

    public static void findAnagramForaList(String[] words, String anagram) {
        // This method can be implemented to group anagrams together if needed.
        AnagramTreeBST anagramTreeBST = new AnagramTreeBST();
        for (String word : words) {
            anagramTreeBST.insert(word);
        }
        List<String> anagrams = anagramTreeBST.getAnagrams(anagram);
        System.out.println("Anagrams of " + anagram + ": " + anagrams);
    }

    public static void main(String[] args) {
        String[] words = {"listen", "silent", "enlist", "inlets", "google", "gogole", "evil", "vile", "live"};
        findUniqueWords(words);
        findAnagramForaList(words, "listen");
    }
}
