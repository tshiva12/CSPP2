/**
 * @author tshiva12
 */
import java.util.Scanner;
/*
   Do not modify this main function.
*/
/**
 * Main class Solution.
 */
public final class Solution {
    /**
     * @Constructs the object.
     */
    private Solution() {
        //constructor is not used
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcdoftwonum(n1, n2);
        System.out.println(gcd);
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**
     * gcd of two numbers function.
     *
     * @param      n1    n1 is input integer
     * @param      n2    n2 is input integer
     *
     * @return     returns the value
     */
    public static int gcdoftwonum(final int n1, final int n2) {
        int temp = 0;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                temp = i;
            }
        }
        return temp;
    }
}













