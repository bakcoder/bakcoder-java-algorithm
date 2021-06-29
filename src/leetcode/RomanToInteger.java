package leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.solution2("MCMXCIV"));
    }

    public int solution1 (String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0 ;
        char[] charArr = s.toCharArray();

        for(int i=0 ; i<charArr.length ; i++) {
            int curNumber = map.get(charArr[i]);
            if(i < charArr.length-1){
                if(curNumber < map.get(charArr[i+1]))
                    sum -= curNumber;
                else
                    sum += curNumber;
            } else {
                sum += curNumber;
            }
        }
        return sum;
    }

    public int solution2(String s) {
        int[] a = new int[26];
        a['I' - 'A'] = 1;
        a['V' - 'A'] = 5;
        a['X' - 'A'] = 10;
        a['L' - 'A'] = 50;
        a['C' - 'A'] = 100;
        a['D' - 'A'] = 500;
        a['M' - 'A'] = 1000;
        char prev = 'A'; // 0

        int sum = 0;
        for(char c : s.toCharArray()) {
            if(a[prev - 'A'] < a[c - 'A'])
                sum -= 2 * a[prev-'A'];

            sum += a[c-'A'];
            prev = c;
        }
        return sum;
    }
}


/*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    Given a roman numeral, convert it to an integer.

    ex)
    Input: s = "III"
    Output: 3

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    * constraint
    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].
*/