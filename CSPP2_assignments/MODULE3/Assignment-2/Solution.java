import java.util.Scanner;
/*
	Do not modify this main function.
	*/
/**
 * Class for solution.
 */
public class Solution {
	/* Fill the main function to print the number of 7's between 1 to n*/
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
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int i = 0, j = 1;
        int count = 0;
        final int a = 10;
        final int b = 7;
        for (i = 1; i <= n; i++) {
        	j = i;
        	while(j != 0) {
        		if(j % a == b) {
        			count++;
        		}
        		j /= a;
        	}
        }
       	System.out.println(count); 
    }
}