package org.prepare;

import java.util.ArrayList;
import java.util.List;

public class TestCode1 {

    public static List<List<Integer>> subset(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length>=1 && nums.length<=10){
            List<Integer> entryList = new ArrayList<>();
            backtrack(result, entryList, nums, 0);
        }
        return result;
    }


    public static void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int sIdex){
        result.add(new ArrayList<>(temp));
        for(int i = sIdex; i< nums.length; i++){
            if(nums[i]>=-10 && nums[i]<=10) {
                temp.add(nums[i]);
                backtrack(result, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


    public static void main(String[] args){

        int[] nums = {1,2,3};
        System.out.println(subset(nums));
    }
}
