package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ShuffleString {
    public static void main(String[] args) {
        ShuffleString ss = new ShuffleString();

        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(ss.otherSolution(s, indices));
    }

    public String solution(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<indices.length ; i++) {
            map.put(indices[i], i);
        }

        for(int j=0 ; j<map.size() ; j++) {
            sb.append(s.charAt(map.get(j)));
        }

        return sb.toString();
    }

    public String otherSolution(String s, int[] indices) {
        char[] charArr = new char[indices.length];

        for(int i=0 ; i<indices.length ; i++) {
            charArr[indices[i]] = s.charAt(i);
        }
        return new String(charArr);
    }


}

//Given a string s and an integer array indices of the same length.
//The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
//Return the shuffled string.

//Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//Output: "leetcode"
//Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

//* constraints
//s.length == indices.length == n
//1 <= n <= 100
//s contains only lower-case English letters.
//0 <= indices[i] < n
//All values of indices are unique (i.e. indices is a permutation of the integers from 0 to n - 1).
