package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] nums = {9,2,1,4,3};
        System.out.println(Arrays.toString(insertionSort.sort(nums)));
    }

    public int[] sort(int[] nums) {

        for(int i = 1 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}