package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "([}}])";
        System.out.println(validParentheses.mySolution2(s));
    }

    public boolean mySolution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArr = s.toCharArray();

        for(int i=0 ; i<charArr.length ; i++) {
            char c = charArr[i];
            if( i == 0 ) {
                if(charArr[i] == ')' || charArr[i] == '}' || charArr[i] == ']')
                    return false;
            } else if( i == charArr.length -1) {
                if (charArr[i] == '(' || charArr[i] == '{' || charArr[i] == '[')
                    return false;
            }

            switch (c) {
                case '(':
                case '{':
                case '[':
                    map.put(c, map.getOrDefault(c, 0) +1);
                    break;
                case ')': {
                    if(charArr[i-1] == '{' || charArr[i-1] == '[')
                        return false;
                    map.put(c, map.getOrDefault(c, 0) +1);
                    break;
                }
                case '}': {
                    if(charArr[i-1] == '(' || charArr[i-1] == '[')
                        return false;
                    map.put(c, map.getOrDefault(c, 0) +1);
                    break;
                }
                case ']': {
                    if(charArr[i-1] == '(' || charArr[i-1] == '{')
                        return false;
                    map.put(c, map.getOrDefault(c, 0) +1);
                    break;
                }
            }
        }

        if(map.get('(') == map.get(')') &&
            map.get('{') == map.get('}') &&
            map.get('[') == map.get(']')) return true;

        return false;
    }

    public boolean mySolution2(String s) {

        Stack<Character> stack = new Stack<>();

        char[] charArr = s.toCharArray();
        int arrLen = charArr.length;

        if ( arrLen == 0 || arrLen % 2 != 0) return false;

        for(int i=0 ; i<arrLen ; i++) {
            char c = charArr[i];
            if ( i == 0 ) {
                if (c == ')' || c == '}' || c == ']')
                    return false;
            } else if ( i == arrLen -1) {
                if (c == '(' || c == '{' || c == '[')
                    return false;
            }

            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')': {
                    if(stack.isEmpty()) return false;

                    if(stack.peek() == '(') {
                        stack.pop();
                    }else return false;

                    break;
                }
                case '}': {
                    if(stack.isEmpty()) return false;

                    if(stack.peek() == '{') {
                        stack.pop();
                    }else return false;

                    break;
                }
                case ']': {
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '[') {
                        stack.pop();
                    }else return false;

                    break;
                }
            }
        }

        return stack.isEmpty();
    }
}

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.

    ex) Input: s = "()"
        Output: true

        Input: s = "()[]{}"
        Output: true

        * constraints
        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.
*/

