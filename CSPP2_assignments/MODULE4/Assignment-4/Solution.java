// Given an String,Write a java method that returns the decimal value
// for the given binary string.
import java.util.Scanner;
/**
 * Class Solution.
 */
public final class Solution {
    /*
    Do not modify the main function
    */
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
     * reverse of a string function.
     *
     * @param      s     s is a input string.
     *
     * @return     return is used to return output.
     */
    public static String reverseString(final String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return reverse;
    }
}
