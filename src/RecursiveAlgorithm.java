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

}
