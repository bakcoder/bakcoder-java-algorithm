package leetcode;

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        RichestCustomerWealth rcw = new RichestCustomerWealth();
        int[][] accounts = {{1,2,3}, {3,2,1}};
        System.out.println(rcw.solution(accounts));
    }

    public int solution(int[][] accounts) {
        int sum = 0;

        for(int i=0 ; i<accounts.length ; i++) {
            int subSum = 0;
            for(int j=0 ; j<accounts[i].length ; j++) {
                subSum += accounts[i][j];
            }
            sum = Math.max(sum, subSum);
        }

        return sum;
    }

    public int otherSolution1(int[][] accounts) { // using loop & stream
        int max = 0;
        for (int[] customer : accounts) {
            int wealth = Arrays.stream(customer).sum();
            max = Math.max(max, wealth);
        }
        return max;
    }

    public int otherSolution2(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customerAccount -> Arrays.stream(customerAccount).sum())
                .max()
                .getAsInt();
    }

}

//    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank.
//    Return the wealth that the richest customer has.
//    A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

//Input: accounts = [[1,2,3],[3,2,1]]
//Output: 6
//Explanation:
//1st customer has wealth = 1 + 2 + 3 = 6
//2nd customer has wealth = 3 + 2 + 1 = 6
//Both customers are considered the richest with a wealth of 6 each, so return 6.

//* constraints
//m == accounts.length
//n == accounts[i].length
//1 <= m, n <= 50
//1 <= accounts[i][j] <= 100
