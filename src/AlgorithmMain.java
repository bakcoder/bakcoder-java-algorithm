public class AlgorithmMain {
    public static void main(String[] args) {
        RecursiveAlgorithm tester = new RecursiveAlgorithm();

        System.out.println("1. 문자열 길이-------------");
        //1. 문자열 길이
       int stringLength = tester.getStringLength("iloveyou");
        System.out.println(stringLength);
        System.out.println("2. 문자열 프린트-------------");
        //2. 문자열 프린트
        tester.getStringPrint("String");

        System.out.println("\n3. 문자열 역프린트-------------");
        //3. 문자열 역프린트
        tester.getStringReversePrint("String");

        System.out.println("\n4. 이진수 출력-------------");
        //4. 이진수 출력
        tester.getBinValue(10);

        System.out.println("\n5. 배열의 합-------------");
        //5. 배열의 합
        int[] arr = {1,2,3,4,5};
        int sumResult = tester.getArrayValueSum(arr, arr.length);
        System.out.println(sumResult);
    }
}
