package leetcode;

import java.util.Stack;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary.otherSolution(a, b));
    }

    public String solution(String a, String b) { // wrong solution
        if("0".equals(a) && "0".equals(b)) return "0";
        if("0".equals(a)) return b;
        if("0".equals(b)) return a;
        // binary to decimal
        int sum = 0, maxLen = Math.max(a.length(), b.length());

        for(int i=0 ; i<maxLen; i++) {
            if(a.length() > i) sum += (a.charAt(a.length()-1-i) -'0') * Math.pow(2, i);
            if(b.length() > i) sum += (b.charAt(b.length()-1-i) -'0') * Math.pow(2, i);
        }


        // decimal to binary
        Stack<Integer> stack = new Stack<>();
        while(true) {
            stack.push(sum%2);
            sum /= 2;

            if(sum == 1) {
                stack.push(sum);
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public String solution2(String a, String b) {

        int lenA = a.length(), lenB = b.length();
        int maxLen = Math.max(lenA, lenB);
        char carry = '0';
        Stack<Character> stack = new Stack<>();
        for(int i=0 ; i<maxLen; i++) {

            char charA = lenA > i ? a.charAt(lenA-1-i) : '0';
            char charB = lenB > i ? b.charAt(lenB-1-i) : '0';

            int sum = charA + charB + carry - 3 * '0';
            if(sum == 3) {
                carry = '1';
                stack.push('1');
            } else if(sum == 2) {
                carry = '1';
                stack.push('0');
            } else if(sum == 1) {
                carry = '0';
                stack.push('1');
            } else if(sum == 0) {
                carry = '0';
                stack.push('0');
            }
        }
        if(carry == '1') stack.push(carry);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public String otherSolution(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int endIdxOfA = a.length() - 1, endIdxOfB = b.length() - 1, carry = 0;
        while(endIdxOfA>=0 || endIdxOfB >=0) {
            int sum = carry;
            if(endIdxOfA >= 0) sum += a.charAt(endIdxOfA--) - '0';
            if(endIdxOfB >= 0) sum += b.charAt(endIdxOfB--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}


/*
    Given two binary strings a and b, return their sum as a binary string.

    * constraints
    1 <= a.length, b.length <= 104
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.
*/