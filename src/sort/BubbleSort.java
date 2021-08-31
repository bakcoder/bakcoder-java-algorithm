package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] nums = {9,2,7,4,1};
        System.out.println(Arrays.toString(bubbleSort.sort(nums)));
    }

    public int[] sort(int[] nums) {
        for(int i=0 ; i<nums.length-1 ; i++) {
            for(int j=1 ; j<nums.length-i ; j++) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
