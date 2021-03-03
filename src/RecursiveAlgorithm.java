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

}
