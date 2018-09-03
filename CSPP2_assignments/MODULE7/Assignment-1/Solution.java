import java.util.*;
class InputValidator {
	/*Write the atrributes and methods for InputValidator*/
	private String input;
	InputValidator(final String str1) {
		this.input = str1;
	}
boolean validateData() {
    	if (input.length() >= 6) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }	
}
public class Solution {
	public static void main(String args[]) {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());
    }
} 


