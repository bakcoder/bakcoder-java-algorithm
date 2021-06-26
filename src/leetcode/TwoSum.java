package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.solution2(nums, target)));
    }

     public int[] solution1(int[] nums, int target) {
         for (int i=0 ; i<nums.length-1 ; i++) {
             for (int j=i+1 ; j<nums.length ; j++) {
                 if(nums[i] + nums[j] == target) return new int[] {i,j};
             }
         }
         return new int[0];
     }

     public int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[0];
     }

}


/*
    Problem
    Given an array of integers nums and an integer target,
    return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution,
    and you may not use the same element twice.
    You can return the answer in any order.

    ex 1)
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*/
