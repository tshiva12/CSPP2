import java.util.Scanner;

public class bigger_equal_smaller
{
    public static void main(String args[])
    {
        int vara, varb;
        Scanner scan = new Scanner(System.in);
		System.out.println("Enter Two Number : ");
        vara = scan.nextInt();
        varb = scan.nextInt();
		if(vara > varb)
        {
            System.out.println("Bigger");  
        }
        else if(vara < varb)
        {
            System.out.println("Smaller");
        }
		else
        {
            System.out.println("Equal");
        }
    }
}