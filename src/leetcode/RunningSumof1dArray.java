package leetcode;

import java.util.Arrays;

public class RunningSumof1dArray {
    public static void main(String[] args) {
        RunningSumof1dArray rs = new RunningSumof1dArray();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(rs.otherSolution(nums)));
    }

    public int[] solution(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0 ; i<result.length ; i++) {
            for(int j=0 ; j<=i ; j++) {
                result[i] += nums[j];
            }
        }
        return result;
    }

    public int[] otherSolution(int[] nums) {
        for(int i=1 ; i<nums.length ; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}

//Given an array nums.
//We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//Return the running sum of nums.