package leetcode;

public class DefanginganIPAddress {
    public static void main(String[] args) {
        DefanginganIPAddress di = new DefanginganIPAddress();
        String address = "1.1.1.1";
        System.out.println(di.solution(address));
    }

    public String solution(String address) {
        return address.replace(".", "[.]");
    }

    public String otherSolution(String address) {

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < address.length(); i++){
            if (address.charAt(i) == '.'){
                str.append("[.]");
            } else {
                str.append(address.charAt(i));
            }
        }
        return str.toString();
    }
}

//Given a valid (IPv4) IP address, return a defanged version of that IP address.
//
//A defanged IP address replaces every period "." with "[.]".

//Input: address = "1.1.1.1"
//Output: "1[.]1[.]1[.]1"

//* constraints
//The given address is a valid IPv4 address.