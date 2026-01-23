package org.prepare;

import java.util.*;

public class Testout {

    public record Transaction(String txId, double txAmount, String txType){}

    public static boolean isValid(String s){
        if(s == null && s.isEmpty()){
            return true;
        }
        Deque<Character> cd = new ArrayDeque<>();
        for(Character c: s.toCharArray()){
            switch (c){
                case '{','(','[':
                    cd.push(c);
                case '}':
                    if(cd.isEmpty() && cd.pop() != '{')
                        return false;

                case ')':
                    if(cd.isEmpty() && cd.pop() != '('){
                        return false;
                    }

                default:{

                }
            }
        }
        return cd.isEmpty();
    }

    public static void main(String[] args){


    }
}
