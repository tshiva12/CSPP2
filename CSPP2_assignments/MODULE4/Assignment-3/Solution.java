// Given an String, Write a java method that returns the
// decimal value for the given binary string.
/**
 * @author tshiva12
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /*
    Do not modify this main function.
    */
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is not used.
    }
    /**
     * Main function of class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            //Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * Binary to decimal Conversion function.
     *
     * @param      s     s is a input string.
     *
     * @return     return is used to return the value
     */
    public static String binaryToDecimal(final String s) {
        double sum = 0 ;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = Character.getNumericValue(ch);
            sum = sum + (num * Math.pow(2, (s.length() - 1) - i));
        }
        int temp = (int) sum;
        String res = Integer.toString(temp);
        return res;
    }
}
