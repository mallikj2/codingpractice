package org.prepare.friday;

public class AnagramTreeBST {
    // Node class to store the sorted key and a list of original words.
    static class Node {
        String key; // Sorted characters
        java.util.List<String> words; // Original words
        Node left, right;

        Node(String key, String word) {
            this.key = key;
            this.words = new java.util.ArrayList<>();
            this.words.add(word);
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public AnagramTreeBST() {
        this.root = null;
    }

    // Method to sort the characters of a string
    private String sortString(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(str.toCharArray());
        return new String(charArray);
    }

    // Method to insert a word into the Anagram Tree
    public void insert(String word) {
        String sortedKey = sortString(word);
        root = insertRec(root, sortedKey, word);
    }

    private Node insertRec(Node node, String key, String word) {
        if (node == null) {
            return new Node(key, word);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.words.add(word);
        } else if (cmp < 0) { // Go left
            node.left = insertRec(node.left, key, word);
        } else {
            node.right = insertRec(node.right, key, word);
        }
        return node;
    }

    // Method to retrieve anagrams of a given word
    public java.util.List<String> getAnagrams(String word) {
        String sortedKey = sortString(word);
        Node node = searchRec(root, sortedKey);
        return node != null ? node.words : new java.util.ArrayList<>();
    }

    private Node searchRec(Node node, String key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return searchRec(node.left, key);
        } else {
            return searchRec(node.right, key);
        }
    }
}
