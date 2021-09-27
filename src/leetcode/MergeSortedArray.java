package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,4,6};
//        int m = 3;
//        int n = 3;
        int[] nums1 = {1};
        int[] nums2 = {};
        int m = 1;
        int n = 0;
        msa.mySolution(nums1, m, nums2, n);
    }

    public void mySolution(int[] nums1, int m, int[] nums2, int n) {
        int pointerOf1 = m-1;
        int pointerOf2 = n-1;

        for(int i=n+m-1 ; i>=0 ; i--) {
            if(m == 0 || pointerOf1 < 0) {
                nums1[i] = nums2[pointerOf2--];
            } else if(n == 0 || pointerOf2 < 0) {
                nums1[i] = nums1[pointerOf1--];
            } else {
                nums1[i] = nums1[pointerOf1] >= nums2[pointerOf2] ?  nums1[pointerOf1--] : nums2[pointerOf2--];
            }
        }
    }

    public void otherSolution(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }

}


//You are given two integer arrays nums1 and nums2
//        , sorted in non-decreasing order
//        , and two integers m and n
//        , representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function
//        , but instead be stored inside the array nums1.
//To accommodate this, nums1 has a length of m + n
//        , where the first m elements denote the elements that should be merged
//        , and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].

//* constraints
//nums1.length == m + n
//nums2.length == n
//0 <= m, n <= 200
//1 <= m + n <= 200
//-10^9 <= nums1[i], nums2[j] <= 10^9
