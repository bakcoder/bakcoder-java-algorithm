package leetcode;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.otherSolution(2147395600));
    }

    public int solution(int x)  {
        if(x == 0) return 0;
        if(x == 1) return 1;

        int n = 1;

        while(Double.valueOf(x)/Double.valueOf(n) > n + 2) {
            n++;
        }

        return n;
    }

    public int otherSolution(int x) { // binary search solution
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}


/*
    Given a non-negative integer x, compute and return the square root of x.

    Since the return type is an integer,
    the decimal digits are truncated, and only the integer part of the result is returned.

    Note: You are not allowed to use any built-in exponent function or operator,
    such as pow(x, 0.5) or x ** 0.5.

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

    * constraints
    0 <= x <= 2^31 - 1
*/