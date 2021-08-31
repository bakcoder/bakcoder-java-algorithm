package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] nums = {9,2,7,4,1};
        System.out.println(Arrays.toString(selectionSort.sort(nums)));
    }

    public int[] sort(int[] nums) {
        for(int i=0 ; i<nums.length ; i++) {
            int selectIdx = i;
            for(int j=i+1 ; j<nums.length ; j++) {
                if(nums[selectIdx] > nums[j]) {
                    selectIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[selectIdx];
            nums[selectIdx] = temp;
        }
        return nums;
    }

}
