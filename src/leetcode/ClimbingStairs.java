package leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int top = 45;
        System.out.println(climbingStairs.solution(top));
    }

    public int solution(int n) {
        int[] dp = new int[n+1];

        for(int i=0 ; i<=n ; i++) {
            if(i <= 0)
                dp[i] =  0;
            else if(i == 1 || i == 2)
                dp[i] = i;
            else dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps

//  Constraints: 1 <= n <= 45



