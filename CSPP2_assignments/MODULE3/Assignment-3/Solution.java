
import java.util.*;
/*
	Do not modify this main function.
	*/
public class Solution {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcdoftwonum(n1,n2);
        System.out.println(gcd);
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcdoftwonum(int n1, int n2) {
        int temp = 0;
        for(int i = 1; i <= n1 && i <= n2; i++)
        {
            if(n1 % i == 0 && n2 % i == 0)
            {
                temp = i;
            }
        }
        return temp;
    }
}
