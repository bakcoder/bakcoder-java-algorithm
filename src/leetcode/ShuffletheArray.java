package leetcode;

import java.util.Arrays;

public class ShuffletheArray {
    public static void main(String[] args) {
        ShuffletheArray sa = new ShuffletheArray();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(sa.solution(nums, n)));
    }

    public int[] solution(int[] nums, int n) {
        int[] result = new int[n*2];
        for(int i=0 ; i<n ; i++) {
            result[i*2] = nums[i];
            result[i*2+1] = nums[n+i];
        }
        return result;
    }
}

//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//Return the array in the form [x1,y1,x2,y2,...,xn,yn].


//Input: nums = [2,5,1,3,4,7], n = 3
//Output: [2,3,5,4,1,7]
//Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

//* constraints
//1 <= n <= 500
//nums.length == 2n
//1 <= nums[i] <= 10^3