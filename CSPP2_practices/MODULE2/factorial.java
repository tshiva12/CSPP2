import java.util.Scanner;
public class factorial
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		int num = scan.nextInt();
		int factorial = fact(num);
		System.out.println(factorial);
	}
	static int fact(int n)
	{
		int res;
		if(n == 1)
		{
			return 1;
		}
		res = fact(n-1) * n;
		return res;

	}	
}