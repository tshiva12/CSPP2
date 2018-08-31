/**
 * @author tshiva12
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Constructor is not used
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**
     * { function_description }.
     *
     * @param      base      base is a integer
     * @param      exponent  exponent is a integer
     *
     * @return     return the value of output
     */
    static long power(final int base, final int exponent) {
        if (exponent > 0) {
            return base * power(base, exponent - 1);
        }
        return 1;
    }
}

