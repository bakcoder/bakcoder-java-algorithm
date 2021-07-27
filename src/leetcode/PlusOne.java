package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9, 9};
        System.out.println(Arrays.toString(plusOne.solution(digits)));
    }

    public int[] solution(int[] digits) {
        int carry = 1;

        int i = digits.length-1;
        while(i>=0) {
            digits[i] = digits[i] + carry;
            if(digits[i] / 10 != 1) {
                carry = 0;
            } else {
                digits[i]  %= 10;
                carry = 1;
            }

            if(carry == 0) break;
            if(i == 0 && carry == 1) {
                int[] result = new int [digits.length + 1];
                result[0] = 1;
//                for(int j=1; j<result.length ; j++ ) {
//                    result[j] = digits[j-1];
//                } // 바보같은 짓..
                return result;
            }
            i--;
        }

        return digits;
    }

    public int[] otherSolution(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}

//Given a non-empty array of decimal digits representing a non-negative integer,
//increment one to the integer.
//The digits are stored such that the most significant digit is at the head of the list,
//and each element in the array contains a single digit.
//You may assume the integer does not contain any leading zero, except the number 0 itself.

// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.

// Input: digits = [9]
// Output: [1,0]


// * constraints
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9