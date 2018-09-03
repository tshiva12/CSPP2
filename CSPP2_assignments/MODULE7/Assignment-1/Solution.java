import java.util.*;
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
	 * boolean function of validateData that prints true or false
	 *
	 * @return     return the true or false based on the condition
	 */
	boolean validateData() {
    	if (input.length() >= 6) {
    		return true;
    	} else {
    		return false;
    	}
    }	
}
/**
 * main class Solution.
 */
public final class Solution {
	/**
	 * main function.
	 */
	public static void main(final String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());
    }
} 


