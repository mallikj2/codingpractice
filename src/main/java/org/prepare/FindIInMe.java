package org.prepare;


import java.util.Arrays;
import java.util.List;

/***
 *
 * List string that contains various items, give the reult of the strings
 * whose second letter is i
 *
 */

public class FindIInMe {

    public static void main(String[] args){
        List<String> stList = Arrays.asList("This", "Nice", "Bottle", "Sit");

        long count = stList.stream().filter(s -> s.length()>1 && s.charAt(1)=='i').count();

        System.out.println(" The count is ...."+ count);

    }



}
