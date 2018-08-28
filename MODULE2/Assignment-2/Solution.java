import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     *Do not modify this main function.
     *@param      args  The arguments
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        rootsOfQuadraticEquation(a, b, c);
    }
    /**
     * { function_description }
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     */
    public static void rootsOfQuadraticEquation(final int a, final int b, final int c)
    {
        double root1;
        double root2;
        int determinant = b * b - (2 * 2 * a * c);
        root1 = (-b + Math.sqrt(determinant)) / (2 * a);
        root2 = (-b - Math.sqrt(determinant)) / (2 * a);
        System.out.format(root1 + " " + root2);
    }
    /*
    Need to write the rootsOfQuadraticEquation
    function and print the output.
    */
}
