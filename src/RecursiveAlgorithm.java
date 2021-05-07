import java.util.List;
import java.util.Stack;

public class RecursiveAlgorithm {

    //1. 문자열 길이 계산
    public int getStringLength(String str) {
        if(str.equals(""))
            return 0;
        else
            return 1 + getStringLength(str.substring(1));
    }

    //2. 문자열 프린트
    public void getStringPrint(String str) {
        if(str.equals(""))
            return;
        else {
            System.out.print(str.charAt(0));
            getStringPrint(str.substring(1));
        }
    }

    //3. 문자열 역프린트
    public void getStringReversePrint(String str) {
        if(str.equals(""))
            return;
        else {
            getStringReversePrint(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    //4. 2진수 출력
    public void getBinValue(int digit) {
        if(digit < 2) {
            System.out.print(digit);
        }else {
            getBinValue(Integer.valueOf(digit/2));
            System.out.print(digit%2);
        }
    }

    //5. 배열의 합 구하기
    public int getArrayValueSum(int[] arr, int len) {
        if(len == 0) {
            return 0;
        }else {
            return arr[len-1] + getArrayValueSum(arr, len-1);
        }
    }

    // 1부터 n까지의 합
    public int sum(int n) {
        if (n == 0)
            return n;
        else
            return n + sum(n-1);
    }

    // combination
    // n : 원소들의 총 갯수,
    // picked : 지금까지 고른 원소들의 번호
    // toPick : 더 고를 원소의 수
    public void combination(int n, Stack<Integer> picked, int toPick) {
        // base case
        if (toPick == 0)
            printPicked(picked);
        else {
            int smallest = picked.isEmpty() ? 0 : picked.peek() + 1;

            for(int i = smallest ; i < n ; i++) {
                picked.push(i);
                combination(n, picked, toPick-1);
                picked.pop();
            }
        }
    }

    public void printPicked(List<Integer> picked) {
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i < picked.size() ; i++) {
            sb.append(picked.get(i));
            if(i != picked.size() -1)
                sb.append(", ");
        }
        System.out.println(sb.toString());
    }

    public void permutation(int n, Stack<Integer> picked, int toPick) {
            if (toPick == 0) {
                printPicked(picked);
            } else {
                for(int i=1 ; i<=n ; i++) {
                    if(!picked.contains(i)) {
                        picked.push(i);
                        permutation(n, picked, toPick - 1 );
                        picked.pop();
                    }
                }
            }
    }
}
