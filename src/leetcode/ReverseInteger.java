package leetcode;

import java.util.Stack;

public class ReverseInteger {
    public static void main(String[] args) {
        int inputX = 1534236469;

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.solution2(inputX));

    }

    // 틀린 솔루션, 예외조건에서 걸러짐
    public int solution1(int inputX) {

        int signed = inputX > 0 ? 1 : inputX < 0 ? -1 : 0;
        if (signed == 0) return 0;
        else if (signed == -1) inputX *= -1;

        String strInputX = String.valueOf(inputX);
        StringBuffer strResult = new StringBuffer();


        Stack<Character> stack = new Stack<>();

        for( int i=0 ; i<strInputX.length() ; i++) {
            if(i != strInputX.length()-1 || strInputX.charAt(i) != '0')
                stack.push(strInputX.charAt(i));
        }

        while( !stack.isEmpty() ) {
            strResult.append(stack.pop());
        }

        return signed * Integer.parseInt(strResult.toString());
    }

    public int solution2(int inputX) {
        int reverseInt = 0;
        while (inputX != 0) {
            int mod = inputX % 10;
            inputX /= 10;
            if ( reverseInt > Integer.MAX_VALUE/10 || (reverseInt == Integer.MAX_VALUE/10 && mod >7)) return 0;

            if ( reverseInt < Integer.MIN_VALUE/10 || (reverseInt == Integer.MIN_VALUE/10 && mod <-8)) return 0;

            reverseInt = reverseInt * 10 + mod;
        }

        return reverseInt;
    }
}

/*
    Given a signed 32-bit integer x,
    return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
    then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    ex )
    Input: x = 123
    Output: 321

    Input: x = -123
    Output: -321

    Input: x = 120
    Output: 21

    Input: x = 0
    Output: 0
*/
