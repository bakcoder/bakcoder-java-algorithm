package leetcode;

public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {5,4,-1,7,8};
        System.out.println(maximumSubarray.solution(nums));
    }

    public int solution(int[] nums) {

        //1. currentSum
        //2. maxSum
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i=1 ; i< nums.length ; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int otherSolution(int[] nums) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}


//Given an integer array nums,
//find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//A subarray is a contiguous part of an array.

//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.

//* constraint
//1 <= nums.length <= 3 * 104
//-105 <= nums[i] <= 105