package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {2,3,2,3,4};
        System.out.println(singleNumber.otherSolution(nums));
    }

    public int solution(int[] nums) {
        Arrays.sort(nums);

        int num = nums[0];
        int cnt = 1;

        if(nums.length == 1) return num;

        for(int i=1 ; i<nums.length ; i++) {
            int temp = nums[i];
            if(num != temp) {
                if(cnt == 1) return num;
                if(i == nums.length-1) return temp;
                cnt = 1;
                num = temp;
            } else {
                cnt++;
            }
        }
        return 0;
    }

    public int solution2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }

    public int otherSolution(int[] nums) {
        int result = 0;

        for (int i = 0; i<nums.length; i++)
        {
            result ^= nums[i];
            System.out.println(result);
        }
        return result;
    }
}


//Given a non-empty array of integers nums,
//every element appears twice except for one. Find that single one.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.

//Input: nums = [2,2,1]
//Output: 1

//* constraints
//1 <= nums.length <= 3 * 104
//-3 * 104 <= nums[i] <= 3 * 104
//Each element in the array appears twice except for one element which appears only once.