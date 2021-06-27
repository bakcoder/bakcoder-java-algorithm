package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int x = 12321;
        System.out.println(palindromeNumber.solution2(x));
    }

    // overflow에 대한 처리가 부족함.
    // solution1 메소드에서는 overflow 일 경우 무조건 false하도록 되어 있음.
    public boolean solution1(int inputX) {
        if ( inputX < 0 ) {
            return false;
        }
        int tempNumber = inputX;
        int reverseNumber = 0;

        while(tempNumber != 0) {
            int mod = tempNumber % 10;
            tempNumber /= 10;

            if ( reverseNumber > Integer.MAX_VALUE / 10 ||
                 ( reverseNumber == Integer.MAX_VALUE && mod > 7)) return false;

            if ( reverseNumber < Integer.MIN_VALUE / 10 ||
                ( reverseNumber == Integer.MIN_VALUE && mod < -8)) return false;

            reverseNumber = 10 * reverseNumber + mod;
        }

        if (inputX == reverseNumber) return true;

        return false;
    }

    public boolean solution2(int inputX) {
        if( inputX < 0 || (inputX % 10 ==0 && inputX != 0)) return false;

        int reverseNumber = 0;

        while ( inputX > reverseNumber ) {
            reverseNumber = 10 * reverseNumber + inputX % 10;
            inputX /= 10;
        }

        return inputX == reverseNumber || inputX == reverseNumber/10;
    }
}


/*
    Given an integer x, return true if x is palindrome integer.

    An integer is a palindrome when it reads the same backward as forward.
    For example, 121 is palindrome while 123 is not.

    ex)
    Input: x = 121
    Output: true

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121.
                 From right to left, it becomes 121-. Therefore it is not a palindrome.

    * constraints
      231 <= x <= 231 - 1
*/

