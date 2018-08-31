/**
 * @author tshiva12
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * @Constructs the object.
     */
    private Solution() {
        //constructor is not used
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        roots(a, b, c);
    }
    /**
     * roots of quadriatic expression function.
     *
     * @param      a     a is a input integer
     * @param      b     b is a input integer
     * @param      c     c is a input integer
     */
    public static void roots(final int a, final int b, final int c) {
        double root1;
        double root2;
        int determinant = b * b - (2 * 2 * a * c);
        root1 = (-b + Math.sqrt(determinant)) / (2 * a);
        root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        System.out.println(root1 + " " + root2);
    }
}




