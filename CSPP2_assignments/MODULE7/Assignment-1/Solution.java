/**
 * @author tshiva12
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**
     * constructor is used.
     */
    private String input;
    /**
     * Constructs the object.
     *
     * @param      str1  The string 1 is a input string.
     */
    InputValidator(final String str1) {
        this.input = str1;
    }
    /**
     * boolean function of validateData that prints true or false.
     *
     * @return     return the true or false based on the condition
     */
    boolean validateData() {
        int len1 = input.length();
        final int max = 6;
        if (len1 >= max) {
            return true;
        }
        return false;
    }
}
/**
 * main class Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is used.
    }
    /**
     * main function.
     *
     * @param      args  The string arguments.
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}





