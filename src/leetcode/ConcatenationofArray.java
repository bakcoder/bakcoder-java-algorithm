package leetcode;

import java.util.Arrays;

public class ConcatenationofArray {
    public static void main(String[] args) {
        ConcatenationofArray ca = new ConcatenationofArray();
        int[] num = {1,2,1};
        System.out.println(Arrays.toString(ca.solution(num)));
    }

    public int[] solution(int[] num) {
        int orgSize = num.length;
        int[] concateArray = new int[orgSize*2];

        for(int i=0 ; i<concateArray.length ; i++) {
            concateArray[i] = num[i % orgSize];
        }
        return concateArray;
    }

    public int[] otherSolution(int[] nums) {
        int[] result = new int[nums.length * 2];
        for(int i=0;i<nums.length;i++)
            result[i + nums.length] = result[i] = nums[i];
        return result;
    }

}


//Given an integer array nums of length n,
// you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//Specifically, ans is the concatenation of two nums arrays.
//Return the array ans.

//Input: nums = [1,2,1]
//Output: [1,2,1,1,2,1]
//Explanation: The array ans is formed as follows:
//- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
//- ans = [1,2,1,1,2,1]


//* constraints
//    n == nums.length
//    1 <= n <= 1000
//    1 <= nums[i] <= 1000