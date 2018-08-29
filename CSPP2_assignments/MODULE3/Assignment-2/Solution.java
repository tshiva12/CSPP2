import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int i = 0, j = 1;
        int count = 0;
        for (i = 1; i <= n; i++) {
        	j = i;
        	while(j != 0) {
        		if(j % 10 == 7) {
        			count++;
        		}
        		j /= 10;
        	}
        }
       	System.out.println(count); 
    }
}