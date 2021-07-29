package leetcode;

public class ImplementstrStr {
    public static void main(String[] args) {
        ImplementstrStr ims = new ImplementstrStr();
        String haystack = "";
        String needle = "";

        System.out.println(ims.solution(haystack, needle));
    }

    public int solution(String haystack, String needle) {
        if(needle == null || needle.isEmpty()) return 0;
        int needLen = needle.length();

        for(int i=0 ; i<haystack.length()-(needLen-1) ; i++) {
            if(needle.equals(haystack.substring(i, i+needLen))) return i;
        }

        return -1;
    }

    public int otherSolution(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}


//Implement strStr().
//
//Return the index of the first occurrence of needle in haystack,
//or -1 if needle is not part of haystack.
//
//Clarification:
//        What should we return when needle is an empty string?
//        This is a great question to ask during an interview.
//        For the purpose of this problem, we will return 0 when needle is an empty string.
//        This is consistent to C's strstr() and Java's indexOf().


//Input: haystack = "hello", needle = "ll"
//Output: 2

//Input: haystack = "aaaaa", needle = "bba"
//Output: -1

//* constarints
//        0 <= haystack.length, needle.length <= 5 * 104
//        haystack and needle consist of only lower-case English characters.