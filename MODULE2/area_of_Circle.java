import java.util.Scanner;

public class area_of_Circle{
	/*
	Do not modify this main function.
	*/
	public static double pi()
	{
		return 3.14;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int radius = scan.nextInt();
		// double pi = pi();
		double area = areaOfCircle(radius);
		System.out.println(area);

	}
	
	public static double areaOfCircle(int radius)
	{
		double pi = pi();
		double area;
		area = pi * radius * radius;
		return area;
	}
}