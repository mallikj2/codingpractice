package org.prepare.friday;

import java.util.Deque;

public class BalancedParanthasis {
    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Deque<Character> stack = new java.util.ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c){
                case '(', '{', '[' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
                default -> {
                    // Ignore other characters
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] testStrings = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}",
            "",
            "((()))",
            "((())",
            "())"
        };
        for (String s : testStrings) {
            System.out.println("isValid(\"" + s + "\") = " + isValid(s));
        }
    }
}
