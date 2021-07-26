package leetcode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition sip = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 7;

        System.out.println(sip.otherSolution(nums, target));
    }

    public int solution(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(true) {

            int mid = left + (right -left)/2 ;

            if(target < nums[mid]) {
                if(mid == 0) return 0;
                right = mid;
            } else {
                if(target == nums[mid]) return mid;
                if(mid == nums.length-1) return mid + 1;
                if(target < nums[mid+1]) return mid + 1;

                left = mid + 1;
            }
        }
    }

    public int otherSolution(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}


//
// Given a sorted array of distinct integers and a target value,
// return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Input: nums = [1], target = 0
// Output: 0
//
// * constraints
//   1 <= nums.length <= 104
//   -104 <= nums[i] <= 104
//   nums contains distinct values sorted in ascending order.
//   -104 <= target <= 104